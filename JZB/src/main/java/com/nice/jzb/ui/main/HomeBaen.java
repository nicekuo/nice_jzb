package com.nice.jzb.ui.main;

import com.core.bean.BaseBean;

import java.util.List;

/**
 * Created by ${nice} on ${2016年04月29日14:09:09}.
 */
public class HomeBaen extends BaseBean {


    /**
     * banner : [{"img":"http://img5.imgtn.bdimg.com/it/u=3288727571,1668503812&fm=21&gp=0.jpg","type":2,"url":"http://life.yxlady.com/health/201510/249201.shtml"}]
     * news : {"title":"头条咨询","news_list":[{"img":"http://static.i3.xywy.com/cms/20141015/1eb0f5cb008bc21b439653566323f9f517388.jpg","content":"脊柱侧弯到底是怎么样一种病?是怎么引起的?","source":"脊诊室主编","like_count":123,"heart_count":43},{"img":"http://static.i3.xywy.com/cms/20141015/1eb0f5cb008bc21b439653566323f9f517388.jpg","content":"脊柱侧弯到底是怎么样一种病?是怎么引起的?","source":"脊诊室主编","like_count":123,"heart_count":43},{"img":"http://static.i3.xywy.com/cms/20141015/1eb0f5cb008bc21b439653566323f9f517388.jpg","content":"脊柱侧弯到底是怎么样一种病?是怎么引起的?","source":"脊诊室主编","like_count":123,"heart_count":43}]}
     * doctor : {"title":"联系医生","doctor_list":[{"avatar":"http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg","name":"赵一鸣","title":"主任医师","hospital":"北京协和医院","doctor_id":"123456"},{"avatar":"http://img.deikang.com/images/201310/21/1382347108_96245200.jpg","name":"于佳佳","title":"医师","hospital":"宣武医院","doctor_id":"123456"},{"avatar":"http://img.taopic.com/uploads/allimg/140704/240455-140F406352283.jpg","name":"王蕾","title":"主治医师","hospital":"中国医科大学附属医院","doctor_id":"123456"}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * title : 头条咨询
         * news_list : [{"img":"http://static.i3.xywy.com/cms/20141015/1eb0f5cb008bc21b439653566323f9f517388.jpg","content":"脊柱侧弯到底是怎么样一种病?是怎么引起的?","source":"脊诊室主编","like_count":123,"heart_count":43},{"img":"http://static.i3.xywy.com/cms/20141015/1eb0f5cb008bc21b439653566323f9f517388.jpg","content":"脊柱侧弯到底是怎么样一种病?是怎么引起的?","source":"脊诊室主编","like_count":123,"heart_count":43},{"img":"http://static.i3.xywy.com/cms/20141015/1eb0f5cb008bc21b439653566323f9f517388.jpg","content":"脊柱侧弯到底是怎么样一种病?是怎么引起的?","source":"脊诊室主编","like_count":123,"heart_count":43}]
         */

        private NewsBean news;
        /**
         * title : 联系医生
         * doctor_list : [{"avatar":"http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg","name":"赵一鸣","title":"主任医师","hospital":"北京协和医院","doctor_id":"123456"},{"avatar":"http://img.deikang.com/images/201310/21/1382347108_96245200.jpg","name":"于佳佳","title":"医师","hospital":"宣武医院","doctor_id":"123456"},{"avatar":"http://img.taopic.com/uploads/allimg/140704/240455-140F406352283.jpg","name":"王蕾","title":"主治医师","hospital":"中国医科大学附属医院","doctor_id":"123456"}]
         */

        private DoctorBean doctor;
        /**
         * img : http://img5.imgtn.bdimg.com/it/u=3288727571,1668503812&fm=21&gp=0.jpg
         * type : 2
         * url : http://life.yxlady.com/health/201510/249201.shtml
         */

        private List<BannerBean> banner;

        public NewsBean getNews() {
            return news;
        }

        public void setNews(NewsBean news) {
            this.news = news;
        }

        public DoctorBean getDoctor() {
            return doctor;
        }

        public void setDoctor(DoctorBean doctor) {
            this.doctor = doctor;
        }

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public static class NewsBean {
            private String title;
            /**
             * img : http://static.i3.xywy.com/cms/20141015/1eb0f5cb008bc21b439653566323f9f517388.jpg
             * content : 脊柱侧弯到底是怎么样一种病?是怎么引起的?
             * source : 脊诊室主编
             * like_count : 123
             * heart_count : 43
             */

            private List<NewsListBean> news_list;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<NewsListBean> getNews_list() {
                return news_list;
            }

            public void setNews_list(List<NewsListBean> news_list) {
                this.news_list = news_list;
            }

            public static class NewsListBean {
                private String img;
                private String content;
                private String source;
                private int like_count;
                private int heart_count;

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getSource() {
                    return source;
                }

                public void setSource(String source) {
                    this.source = source;
                }

                public int getLike_count() {
                    return like_count;
                }

                public void setLike_count(int like_count) {
                    this.like_count = like_count;
                }

                public int getHeart_count() {
                    return heart_count;
                }

                public void setHeart_count(int heart_count) {
                    this.heart_count = heart_count;
                }
            }
        }

        public static class DoctorBean {
            private String title;
            /**
             * avatar : http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg
             * name : 赵一鸣
             * title : 主任医师
             * hospital : 北京协和医院
             * doctor_id : 123456
             */

            private List<DoctorListBean> doctor_list;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<DoctorListBean> getDoctor_list() {
                return doctor_list;
            }

            public void setDoctor_list(List<DoctorListBean> doctor_list) {
                this.doctor_list = doctor_list;
            }

            public static class DoctorListBean {
                private String avatar;
                private String name;
                private String title;
                private String hospital;
                private String doctor_id;

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getHospital() {
                    return hospital;
                }

                public void setHospital(String hospital) {
                    this.hospital = hospital;
                }

                public String getDoctor_id() {
                    return doctor_id;
                }

                public void setDoctor_id(String doctor_id) {
                    this.doctor_id = doctor_id;
                }
            }
        }

        public static class BannerBean {
            private String img;
            private int type;
            private String url;

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
