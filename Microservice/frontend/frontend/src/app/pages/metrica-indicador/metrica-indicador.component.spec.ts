import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MetricaIndicadorComponent } from './metrica-indicador.component';

describe('MetricaIndicadorComponent', () => {
  let component: MetricaIndicadorComponent;
  let fixture: ComponentFixture<MetricaIndicadorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MetricaIndicadorComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MetricaIndicadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
