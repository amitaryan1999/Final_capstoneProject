import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProprtyMainComponent } from './proprty-main.component';

describe('ProprtyMainComponent', () => {
  let component: ProprtyMainComponent;
  let fixture: ComponentFixture<ProprtyMainComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProprtyMainComponent]
    });
    fixture = TestBed.createComponent(ProprtyMainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
