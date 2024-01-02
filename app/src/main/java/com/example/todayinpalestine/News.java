package com.example.todayinpalestine;

public class News {
        private String name,title,imageUrl,desc,url,publishedAt;
        public News(String name, String title, String desc, String url, String imageUrl,String publishedAt) {
            this.name = name;
            this.title = title;
            this.desc = desc;
            this.url = url;
            this.imageUrl = imageUrl;
            this.publishedAt = publishedAt;

        }

        public String getName() {
            return name;
        }




    public String getTitle() {
        return title;
    }


            public String getDesc() {
                return desc;
            }
                public void setDesc(String desc) {
                    this.desc=desc;
                }
                public String getUrl() {
                    return url;
                }


    public String getImageUrl() {
        return imageUrl;
    }




    }

