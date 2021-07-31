import { Component, Input, OnInit } from '@angular/core';
import { NbDialogRef } from '@nebular/theme';
import { Veiculo } from 'src/app/model/veiculo';

@Component({
  selector: 'app-cadastro-veiculo',
  templateUrl: './cadastro-veiculo.component.html',
  styleUrls: ['./cadastro-veiculo.component.scss'],
})
export class CadastroVeiculoComponent implements OnInit {
  @Input() title!: string;
  @Input() id!: number;
  @Input() veiculo!: Veiculo;

  constructor(protected ref: NbDialogRef<CadastroVeiculoComponent>) {}

  ngOnInit(): void {}

  dismiss() {
    this.ref.close();
  }
}
