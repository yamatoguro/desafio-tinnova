import { Component, Input, OnInit } from '@angular/core';
import { NbDialogRef } from '@nebular/theme';
import { Veiculo } from 'src/app/model/veiculo';
import { DialogService } from 'src/app/service/dialog.service';
import { VeiculoService } from 'src/app/service/veiculo.service';

@Component({
  selector: 'app-cadastro-veiculo',
  templateUrl: './cadastro-veiculo.component.html',
  styleUrls: ['./cadastro-veiculo.component.scss'],
})
export class CadastroVeiculoComponent implements OnInit {
  @Input() title!: string;
  @Input() id!: number;
  @Input() veiculo!: Veiculo;

  constructor(
    protected ref: NbDialogRef<CadastroVeiculoComponent>,
    private service: VeiculoService,
    private dialogService: DialogService
  ) {
    if (this.veiculo === null || this.veiculo === undefined) {
      this.veiculo = {
        id: 0,
        veiculo: '',
        marca: '',
        ano: 0,
        descricao: '',
        vendido: false,
        created: new Date(Date.now()),
        updated: new Date(Date.now()),
      };
    }
  }

  ngOnInit(): void {}

  dismiss() {
    this.ref.close();
  }

  send() {
    if (this.id > 0) {
      this.service.newVeiculo(this.veiculo).subscribe((r) => {
        this.dismiss();
        this.dialogService.openAlertDialog(
          'Atualizado',
          'Veículo atualizado!',
          'OK',
          null,
          () => {
            window.location.reload();
          }
        );
      });
    } else {
      this.service.newVeiculo(this.veiculo).subscribe((r) => {
        this.dismiss();
        this.dialogService.openAlertDialog(
          'Cadastrado',
          'Veículo cadastrado!',
          'OK',
          null,
          () => {
            window.location.reload();
          }
        );
      });
    }
  }
}
