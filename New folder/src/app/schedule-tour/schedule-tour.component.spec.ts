import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScheduleTourComponent } from './schedule-tour.component';

describe('ScheduleTourComponent', () => {
  let component: ScheduleTourComponent;
  let fixture: ComponentFixture<ScheduleTourComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ScheduleTourComponent]
    });
    fixture = TestBed.createComponent(ScheduleTourComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
