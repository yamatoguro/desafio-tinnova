import { Component, Inject, Input, OnInit, Output } from '@angular/core';
import { NbDialogRef } from '@nebular/theme';

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.scss'],
})
export class DialogComponent implements OnInit {
  public CONFIRM_DIALOG = 'CONFIRM';
  public INPUT_DIALOG = 'INPUT';
  public ALERT_DIALOG = 'ALERT';
  public SIMPLE_DIALOG = 'SIMPLE';
  @Input() title!: string;
  @Input() text!: string;
  @Input() close!: string;
  @Input() save!: string;
  @Input() @Output() data!: string;
  @Input() dialogType!: string;
  @Input() @Output() confirm!: boolean;

  constructor(public dialogRef: NbDialogRef<DialogComponent>) {}
  ngOnInit() {}

  onNoClick(): void {
    this.confirm = false;
    this.dialogRef.close(this.confirm);
  }

  onYesClick(): void {
    this.confirm = true;
    this.dialogRef.close(this.confirm); 
  }
}
