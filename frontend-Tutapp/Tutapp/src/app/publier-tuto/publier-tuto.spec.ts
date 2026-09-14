import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PublierTuto } from './publier-tuto';

describe('PublierTuto', () => {
  let component: PublierTuto;
  let fixture: ComponentFixture<PublierTuto>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PublierTuto],
    }).compileComponents();

    fixture = TestBed.createComponent(PublierTuto);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
