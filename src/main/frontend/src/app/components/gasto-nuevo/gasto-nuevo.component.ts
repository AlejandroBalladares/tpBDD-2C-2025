import { Output } from '@angular/core';
import { EventEmitter } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';
import { Grupo } from '../../model/grupo';
import { IdentificarGrupoPipe } from '../../pipes/identificar-grupo.pipe';
import { GrupoService } from '../../services/grupo.service';
import { NombreService } from '../../services/nombre.service';

@Component({
  selector: 'app-gasto-nuevo',
  templateUrl: './gasto-nuevo.component.html',
  styleUrls: ['./gasto-nuevo.component.css']
})
export class GastoNuevoComponent implements OnInit {

  mostrar: boolean = false;

  grupo: Grupo;

  monto: number = 0.0;

  @Output() readonly guardadoEvent = new EventEmitter<void>();

  constructor(
    private grupoService: GrupoService,
    private messageService: MessageService,
    private identificarGrupo: IdentificarGrupoPipe,
    private nombreService: NombreService
  ) { }

  ngOnInit(): void { }

  iniciarPara(grupo: Grupo): void {
    this.mostrar = true;
    this.grupo = grupo;
    this.monto = 0.0;
  }

  cancelar(): void {
    this.mostrar = false;
  }

  guardar(): void {

    const usuario = this.nombreService.getNombre();
    //console.log('DEBUG NombreService.getNombre() ->', usuario, ' tipo:', typeof usuario);
    const gasto = {
      monto: this.monto,
      nombre: usuario
    };

    this.grupoService.agregarGasto(this.grupo, gasto)
      .subscribe(
        grupo => this.guardadoExitoso(grupo),
        error => this.guardadoFallido(error)
      );
  }

  private guardadoExitoso(grupo: Grupo): void {
    this.messageService.add({
      severity: 'success',
      summary: 'Éxito',
      detail: `Gasto agregado al grupo '${this.identificarGrupo.transform(grupo)}'`,
    });
    this.guardadoEvent.emit();
    this.mostrar = false;
  }

  private guardadoFallido(error: any): void {
    this.messageService.add({
      severity: 'error',
      summary: 'Error',
      detail: error.mensaje,
    });
  }
}
