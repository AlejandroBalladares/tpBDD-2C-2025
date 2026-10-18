import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NombreService {
  private nombreSubject = new BehaviorSubject<string>('');
  nombre$ = this.nombreSubject.asObservable();

  setCreador(nombre: string) {
    this.nombreSubject.next(nombre);
  }

  getCreador(): string {
    return this.nombreSubject.value;
  }
}