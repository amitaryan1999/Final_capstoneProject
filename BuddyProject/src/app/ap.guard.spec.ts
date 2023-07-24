import { TestBed } from '@angular/core/testing';
import { CanActivateFn } from '@angular/router';

import { apGuard } from './ap.guard';

describe('apGuard', () => {
  const executeGuard: CanActivateFn = (...guardParameters) => 
      TestBed.runInInjectionContext(() => apGuard(...guardParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });
});
