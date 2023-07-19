import { TestBed } from '@angular/core/testing';

import { FeaturedPService } from './featured-p.service';

describe('FeaturedPService', () => {
  let service: FeaturedPService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FeaturedPService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
