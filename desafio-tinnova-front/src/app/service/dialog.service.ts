import { Injectable } from '@angular/core';
import { NbDialogRef, NbDialogService } from '@nebular/theme';
import { DialogComponent } from '../components/dialog/dialog.component';

@Injectable({
  providedIn: 'root'
})
export class DialogService {

  public CONFIRM_DIALOG = 'CONFIRM';
  public INPUT_DIALOG = 'INPUT';
  public ALERT_DIALOG = 'ALERT';
  public SIMPLE_DIALOG = 'SIMPLE';
  constructor(public dialog: NbDialogService) {}
  openConfirmDialog(title: any, content: any, buttonClose: any, buttonSave: any, data: any, method: any): void {
    const dialogRef = this.dialog.open(DialogComponent, {
      context: {
        title: title,
        text: content,
        close: buttonClose,
        save: buttonSave,
        data: '',
        dialogType: this.CONFIRM_DIALOG,
        confirm: data
       }
    });
    dialogRef.onClose.subscribe(confirm => {
      method(confirm);
    });
  }

  openInputDialog(title: any, content: any, buttonClose: any, buttonSave: any, data: any, method: any): void {
    const dialogRef = this.dialog.open(DialogComponent, {
      context: {
        title: title,
        text: content,
        close: buttonClose,
        save: buttonSave,
        data: data,
        dialogType: this.INPUT_DIALOG
       }
    });
    dialogRef.onClose.subscribe(data => {
      method(data);
    });
  }

  openAlertDialog(title: any, content: any, buttonSave: any, data: any, method: any): void {
    const dialogRef = this.dialog.open(DialogComponent, {
      context: {
        title: title,
        text: content,
        close: '',
        save: buttonSave,
        data: data,
        dialogType: this.ALERT_DIALOG
       }
    });
    dialogRef.onClose.subscribe(data => {
      method(data);
    })
  }

  openSimpleDialog(title: any, content: any): void {
    const dialogRef = this.dialog.open(DialogComponent, {
      context: {
        title: title,
        text: content,
        close: '',
        save: '',
        data: '',
        dialogType: this.SIMPLE_DIALOG
       }
    });
  }
}
