import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Veiculo } from '../model/veiculo';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class VeiculoService {
  url = environment.baseUrl + '/veiculos';

  constructor(private http: HttpClient) { }

  getVeiculos(): Observable<Veiculo[]> {
    return this.http.get<Veiculo[]>(this.url);
  }

  getVeiculo(id: number) {
    return this.http.get<Veiculo>(this.url + '/' + id);
  }

  excluirVeiculo(id: number) {
    return this.http.delete(this.url + '/' + id);
  }

  newVeiculo(veiculo: Veiculo) {
    const params = new HttpParams()
      .append('veiculo', veiculo.veiculo)
      .append('marca', veiculo.marca)
      .append('ano', veiculo.ano)
      .append('descricao', veiculo.descricao)
      .append('vendido', veiculo.vendido);
    return this.http.post(this.url, params);
  }

  putVeiculo(veiculo: Veiculo) {
    const params = new HttpParams()
      .append('veiculo', veiculo.veiculo)
      .append('marca', veiculo.marca)
      .append('ano', veiculo.ano)
      .append('descricao', veiculo.descricao)
      .append('vendido', veiculo.vendido);
    return this.http.put(this.url, params);
  }

  patchVeiculo(veiculo: Veiculo) {
    const params = new HttpParams();
    if ( veiculo.veiculo != null && veiculo.veiculo != undefined && veiculo.veiculo != '' ) {
      params.append('veiculo', veiculo.veiculo);
    }
    if ( veiculo.marca != null && veiculo.marca != undefined && veiculo.marca != '' ) {
      params.append('marca', veiculo.marca);
    }
    if (veiculo.ano != null && veiculo.ano != undefined && veiculo.ano != 0) {
      params.append('ano', veiculo.ano);
    }
    if ( veiculo.descricao != null && veiculo.descricao != undefined && veiculo.descricao != '' ) {
      params.append('descricao', veiculo.descricao);
    }
    if (veiculo.vendido != null && veiculo.vendido != undefined) {
      params.append('vendido', veiculo.vendido);
    }
    return this.http.patch(this.url, params);
  }


  searchVeiculo(filtro: string): Observable<Veiculo[]> {
    const params = new HttpParams().set('termo', filtro);
    return this.http.get<Veiculo[]>(this.url + '/find', {params});
  }
}
