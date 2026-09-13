import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarTop } from './navbar-top';

describe('NavbarTop', () => {
  let component: NavbarTop;
  let fixture: ComponentFixture<NavbarTop>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NavbarTop],
    }).compileComponents();

    fixture = TestBed.createComponent(NavbarTop);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
