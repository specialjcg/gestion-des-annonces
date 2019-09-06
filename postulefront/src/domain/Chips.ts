export class Chips {
    id: number;
    chip1: string;
    chip2: string;
    chip3: string;
    chip4: string;
    chip5: string;
    chip6: string;
    chip7: string;
    chip8: string;
    chip9: string;
    constructor() {
      this.id = 0;
      this.chip1 = "";
      this.chip2 = "";
      this.chip3 = "";
      this.chip4 = "";
      this.chip5 = "";
      this.chip6 = "";
      this.chip7 = "";
      this.chip8 = "";
      this.chip9 = "";
    }
  
    transfert(item: string[]) {
      if (item[0] != "") {
        this.chip1 = item[0];
      }
      if (item[1] != "") {
        this.chip2 = item[1];
      }
      if (item[2] != "") {
        this.chip3 = item[2];
      }
      if (item[3] != "") {
        this.chip4 = item[3];
      }
      if (item[4] != "") {
        this.chip5 = item[4];
      }
      if (item[5] != "") {
        this.chip6 = item[5];
      }
      if (item[6] != "") {
        this.chip7 = item[6];
      }
      if (item[7] != "") {
        this.chip8 = item[7];
      }
      if (item[8] != "") {
        this.chip9 = item[8];
      }
    }
  }
  