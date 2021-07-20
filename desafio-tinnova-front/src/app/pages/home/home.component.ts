import { Component, OnInit } from '@angular/core';
import { NbDialogService } from '@nebular/theme';
import { Veiculo } from 'src/app/model/veiculo';
import { VeiculoService } from 'src/app/service/veiculo.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  filtro: string = '';
  data: Veiculo[] = [];
  current = 0;
  size = 0;

  constructor(private service: VeiculoService, private dialogService: NbDialogService) {
    this.service.getVeiculos().subscribe((veiculos: Veiculo[]) => {
      this.data = veiculos;
    });
  }

  ngOnInit(): void { }

}
