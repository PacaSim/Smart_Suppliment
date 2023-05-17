package kr.co.company.smart_application.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

        @SerializedName("item")
        @Expose
        private Item__1 item;

        public Item__1 getItem() {
            return item;
        }

        public void setItem(Item__1 item) {
            this.item = item;
        }
}
