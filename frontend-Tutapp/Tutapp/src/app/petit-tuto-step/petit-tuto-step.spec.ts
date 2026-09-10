import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PetitTutoStep } from './petit-tuto-step';

describe('PetitTutoStep', () => {
  let component: PetitTutoStep;
  let fixture: ComponentFixture<PetitTutoStep>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PetitTutoStep],
    }).compileComponents();

    fixture = TestBed.createComponent(PetitTutoStep);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
