import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavPostConn } from './nav-post-conn';

describe('NavPostConn', () => {
  let component: NavPostConn;
  let fixture: ComponentFixture<NavPostConn>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NavPostConn],
    }).compileComponents();

    fixture = TestBed.createComponent(NavPostConn);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
