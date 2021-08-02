import { Component, OnInit } from '@angular/core';
import { NbDialogService, NbSearchService } from '@nebular/theme';
import { CadastroVeiculoComponent } from 'src/app/components/cadastro-veiculo/cadastro-veiculo.component';
import { Veiculo } from 'src/app/model/veiculo';
import { DialogService } from 'src/app/service/dialog.service';
import { VeiculoService } from 'src/app/service/veiculo.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  filtro: string = '';
  data: Veiculo[] = [];
  current = 0;
  size = 0;
  vendidos = 0;

  constructor(
    private service: VeiculoService,
    private nbDialogService: NbDialogService,
    private dialogService: DialogService,
    private searchService: NbSearchService
  ) {
    this.getVeiculos();
    this.searchService.onSearchSubmit().subscribe((data: any) => {
      this.filtro = data.term;
      this.filtrar();
    });
  }

  ngOnInit(): void {
    this.vendidos = this.calcVendidos();
  }

  onCreate() {
    this.nbDialogService.open(CadastroVeiculoComponent, {
      context: { title: 'Cadastrar Veículo' },
    });
  }

  onEdit(id: number) {
    this.service.getVeiculo(id).subscribe((v) => {
      this.nbDialogService.open(CadastroVeiculoComponent, {
        context: {
          title: 'Atualizar Veículo: ' + v.marca + ' ' + v.veiculo,
          id: v.id,
          veiculo: v,
        },
      });
    });
  }

  onDelete(id: number): void {
    let excluir = false;
    this.dialogService.openConfirmDialog(
      'Excluir veículo',
      'Deseja excluir o veículo ' + id + '?',
      'Cancelar',
      'Confirmar',
      excluir,
      (excluir: any) => {
        if (excluir) {
          this.service.excluirVeiculo(id).subscribe((r) => {
            this.dialogService.openAlertDialog(
              'Excluído',
              'Veículo excluído',
              'OK',
              null,
              () => {
                window.location.reload();
              }
            );
          });
        }
      }
    );
  }

  filtrar() {
    this.service.searchVeiculo(this.filtro).subscribe((v: Veiculo[]) => {
      this.data = v;
    });
  }

  getVeiculos() {
    this.service.getVeiculos().subscribe((veiculos: Veiculo[]) => {
      this.data = veiculos;
    });
  }

  calcVendidos() {
    let vendidosCount = 0;
    this.data.forEach((v) => {
      console.log(v.vendido);
      if (v.vendido == true) {
        vendidosCount += 1;
      }
    });
    return vendidosCount;
  }

  calcMarcas() {
    let marcas: { marca: string; count: number }[] = [];
    this.data.forEach((v: Veiculo) => {
      const i = marcas.filter((m) => m.marca == v.marca);
      if (i.length > 0) {
        i.forEach((i) => i.count++);
      } else {
        marcas.push({ marca: v.marca, count: 1 });
      }
    });
    return marcas;
  }

  calcDecadas() {
    let decs: { ano1: number; ano2: number; count: number }[] = [];
    let anoMaior = 0,
      anoMenor = 100000;
    this.data.forEach((v: Veiculo) => {
      if (v.ano < anoMenor) {
        anoMenor = v.ano;
      }
      if (v.ano > anoMaior) {
        anoMaior = v.ano;
      }
    });
    for (let i = 0; i <= ((anoMaior - anoMenor) / 10) + 1; i++) {
      let ano1 = anoMenor + i * 10,
        ano2 = anoMenor + i * 10 + 10;
      ano1 = ano1 - (ano1%10) + 1;
      ano2 = ano2 - (ano2%10);
      console.log(ano1,ano2);
      decs.push({ ano1: ano1, ano2: ano2, count: 0 });
      decs.forEach((d) => {
        d.count = this.data.filter(
          (v) => (d.ano2 >= v.ano && d.ano1 <= v.ano)
        ).length;
      });
    }
    return decs;
  }
}
