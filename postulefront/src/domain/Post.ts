export class Post {
    id: number;
    text: number;
    time: Date;
    timeformat: string;
    dialog: boolean;
    show1: boolean;
    show: boolean;
    srcimg: string;
    chipspost: string[];
    chipspostId: number;
    target: string;
    srcimage: string;
    constructor() {
      this.id = 0;
      this.text = 0;
      this.time = new Date();
      this.timeformat = "";
      this.dialog = false;
      this.srcimg = "";
      this.chipspost = [];
      this.chipspostId = 0;
      this.srcimage = "";
      this.target = "";
      this.show = false;
      this.show1 = false;
    }
  }