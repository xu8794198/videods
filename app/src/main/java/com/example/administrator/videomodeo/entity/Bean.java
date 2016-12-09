package com.example.administrator.videomodeo.entity;

import java.util.List;

/**
 * 看接口数据对应解析的实体类
 * Created by Administrator on 2016/12/8.
 */
public class Bean {
    private int status;
    private static MsgEntity msg;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static MsgEntity getMsg() {
        return msg;
    }

    public void setMsg(MsgEntity msg) {
        this.msg = msg;
    }

    public static class MsgEntity {
        /**
         * id : 9
         * name : 小羊肖恩
         * fmPic : /upload/image/movie/HHFHP02810_082127.jpg
         * totalCount : 120
         * description : 故事主要讲述一只小绵羊和伙伴们在牧场的生活故事。它们不是那种兢兢业业吃草长毛的乖乖羊，而是调皮捣蛋又活泼好动的棉花糖，生活充满了快乐生趣。有时运动运动，或者和一...
         * view : 15
         * date : 2016-12-07
         * typeNames : 大陆 0-3岁
         * isSc : false
         * itemNum : 1
         * itemName : 001 足球比赛
         * itemUrl : /upload/media/N86Z642510_807631.mp4
         * itemList : [{"itemNum":1,"itemName":"001 足球比赛","itemUrl":"/upload/media/N86Z642510_807631.mp4"},{"itemNum":2,"itemName":"002 爱的季节","itemUrl":"/upload/media/8406F83410_564732.mp4"},{"itemNum":3,"itemName":"003 洗澡日","itemUrl":"/upload/media/0ZTR644910_803532.mp4"},{"itemNum":4,"itemName":"004 马戏团大冒险","itemUrl":"/upload/media/PV0HL81110_889233.mp4"},{"itemNum":5,"itemName":"005 公牛","itemUrl":"/upload/media/0PZR8J3110_872233.mp4"}]
         */

        private int id;
        private String name;
        private String fmPic;
        private int totalCount;
        private String description;
        private int view;
        private String date;
        private String typeNames;
        private boolean isSc;
        private int itemNum;
        private String itemName;
        private String itemUrl;
        private List<ItemListEntity> itemList;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFmPic() {
            return fmPic;
        }

        public void setFmPic(String fmPic) {
            this.fmPic = fmPic;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getView() {
            return view;
        }

        public void setView(int view) {
            this.view = view;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTypeNames() {
            return typeNames;
        }

        public void setTypeNames(String typeNames) {
            this.typeNames = typeNames;
        }

        public boolean isIsSc() {
            return isSc;
        }

        public void setIsSc(boolean isSc) {
            this.isSc = isSc;
        }

        public int getItemNum() {
            return itemNum;
        }

        public void setItemNum(int itemNum) {
            this.itemNum = itemNum;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public String getItemUrl() {
            return itemUrl;
        }

        public void setItemUrl(String itemUrl) {
            this.itemUrl = itemUrl;
        }

        public List<ItemListEntity> getItemList() {
            return itemList;
        }

        public void setItemList(List<ItemListEntity> itemList) {
            this.itemList = itemList;
        }

        public static class ItemListEntity {
            /**
             * itemNum : 1
             * itemName : 001 足球比赛
             * itemUrl : /upload/media/N86Z642510_807631.mp4
             */

            private int itemNum;
            private String itemName;
            private String itemUrl;

            public int getItemNum() {
                return itemNum;
            }

            public void setItemNum(int itemNum) {
                this.itemNum = itemNum;
            }

            public String getItemName() {
                return itemName;
            }

            public void setItemName(String itemName) {
                this.itemName = itemName;
            }

            public String getItemUrl() {
                return itemUrl;
            }

            public void setItemUrl(String itemUrl) {
                this.itemUrl = itemUrl;
            }
        }
    }
}


