import { TestBed } from '@angular/core/testing';

import { CrouselService } from './crousel.service';

describe('CrouselService', () => {
  let service: CrouselService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CrouselService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
