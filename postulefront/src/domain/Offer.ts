export class Offer {
    id: number;
    text: number;
    time: Date;
    timeformat: string;
    dialog: boolean;
    show1: boolean;
    show: boolean;
    srcimg: string;
    features: string[];
    featureId: number;
    target: string;
    srcimage: string;
    constructor() {
      this.id = 0;
      this.text = 0;
      this.time = new Date();
      this.timeformat = "";
      this.dialog = false;
      this.srcimg = "";
      this.features = [];
      this.featureId = 0;
      this.srcimage = "";
      this.target = "";
      this.show = false;
      this.show1 = false;
    }
  }