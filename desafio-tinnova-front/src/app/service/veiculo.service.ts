import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Veiculo } from '../model/veiculo';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VeiculoService {
  
  url = environment.baseUrl + "/veiculos";

  constructor(private http: HttpClient) { }

  getVeiculos() : Observable<Veiculo[]> {
    return this.http.get<Veiculo[]>(this.url);
  }

  getVeiculo(id: number) {
    return this.http.get<Veiculo>(this.url  + "/" + id);
  }

  excluirVeiculo(id: number) {
    return this.http.delete(this.url + "/" + id);
  }
}
