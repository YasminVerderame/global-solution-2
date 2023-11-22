import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { MetricaIndicadorComponent } from './pages/metrica-indicador/metrica-indicador.component';

export const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'metrica', component: MetricaIndicadorComponent },
];
