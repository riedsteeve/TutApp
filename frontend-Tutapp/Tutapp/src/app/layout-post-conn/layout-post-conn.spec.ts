import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LayoutPostConn } from './layout-post-conn';

describe('LayoutPostConn', () => {
  let component: LayoutPostConn;
  let fixture: ComponentFixture<LayoutPostConn>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LayoutPostConn],
    }).compileComponents();

    fixture = TestBed.createComponent(LayoutPostConn);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
