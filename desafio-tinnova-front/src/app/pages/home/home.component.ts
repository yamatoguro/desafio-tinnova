import { Component, OnInit } from '@angular/core';
import { NbDialogService } from '@nebular/theme';
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
  console = console;

  constructor(
    private service: VeiculoService,
    private nbDialogService: NbDialogService,
    private dialogService: DialogService
  ) {
    this.service.getVeiculos().subscribe((veiculos: Veiculo[]) => {
      this.data = veiculos;
    });
  }

  ngOnInit(): void {}

  onCreate() {
    this.nbDialogService.open(CadastroVeiculoComponent, {
      context: { title: 'Cadastrar Veículo'}
    });
  }

  onEdit(id: number) {
    this.service.getVeiculo(id).subscribe((v) => {
      this.nbDialogService.open(CadastroVeiculoComponent, {
        context: { title: 'Atualizar Veículo: ' + v.marca + ' ' + v.veiculo, id: v.id, veiculo: v },
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

  filtrar(){
    this.service.searchVeiculo(this.filtro).subscribe((v: Veiculo[]) => {
      this.data = v;      
    });
  }
}
