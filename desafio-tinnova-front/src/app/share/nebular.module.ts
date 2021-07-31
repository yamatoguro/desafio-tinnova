import { NgModule } from '@angular/core';
import {
  NbActionsModule,
  NbButtonModule,
  NbCardModule,
  NbDialogModule,
  NbDialogService,
  NbIconModule,
  NbInputModule,
  NbMenuModule,
  NbMenuService,
  NbRadioModule,
  NbSearchModule,
  NbSearchService,
  NbSidebarModule,
  NbSidebarService,
  NbToastrModule,
  NbToastrService,
  NbToggleModule,
  NbTooltipModule,
  NbUserModule,
} from '@nebular/theme';

@NgModule({
  imports: [
    NbSidebarModule,
    NbCardModule,
    NbButtonModule,
    NbTooltipModule,
    NbInputModule,
    NbIconModule,
    NbMenuModule.forRoot(),
    NbTooltipModule,
    NbSearchModule,
    NbActionsModule,
    NbUserModule,
    NbToastrModule.forRoot(),
    NbDialogModule,
    NbDialogModule.forRoot(),
    NbRadioModule,
    NbToggleModule
  ],
  exports: [
    NbSidebarModule,
    NbCardModule,
    NbButtonModule,
    NbTooltipModule,
    NbInputModule,
    NbIconModule,
    NbMenuModule,
    NbTooltipModule,
    NbSearchModule,
    NbActionsModule,
    NbUserModule,
    NbToastrModule,
    NbDialogModule,
    NbRadioModule,
    NbToggleModule
  ],
  providers: [
    NbSidebarService,
    NbMenuService,
    NbSearchService,
    NbToastrService,
    NbDialogService
  ],
})
export class NebularModule {}
