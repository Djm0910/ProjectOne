package demo.example.com.pandalive.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 丁军明 on 2017/12/23.
 */

public class FuYong {

    /**
     * videoset : {"0":{"vsid":"VSET100167216881","relvsid":"","name":"熊猫频道-精彩一刻","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100167216881","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"2013-05-01","sbpd":"其他","desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","playdesc":"","zcr":"","fcl":""},"count":"5724"}
     * video : [{"vsid":"VSET100167216881","order":"5736","vid":"31f599df9e704307aa52e61fcba13596","t":"《精彩一刻》 20171223 我是个爱洗澡澡的宝宝~","url":"http://tv.cntv.cn/video/VSET100167216881/31f599df9e704307aa52e61fcba13596","ptime":"2017-12-23 09:34:18","img":"http://p5.img.cctvpic.com/fmspic/2017/12/23/31f599df9e704307aa52e61fcba13596-20.jpg?p=2&h=120","len":"00:00:20","em":"CM01"},{"vsid":"VSET100167216881","order":"5738","vid":"7d70971de5194021b75d2dbaad4296f6","t":"《精彩一刻》 20171223 感受到没有！我是猛兽！","url":"http://tv.cntv.cn/video/VSET100167216881/7d70971de5194021b75d2dbaad4296f6","ptime":"2017-12-23 09:33:36","img":"http://p2.img.cctvpic.com/fmspic/2017/12/23/7d70971de5194021b75d2dbaad4296f6-21.jpg?p=2&h=120","len":"00:00:32","em":"CM01"},{"vsid":"VSET100167216881","order":"5737","vid":"a970037149ea4e9db395cc90fadd2258","t":"《精彩一刻》 20171223 这一定就是周末不想起床的你了","url":"http://tv.cntv.cn/video/VSET100167216881/a970037149ea4e9db395cc90fadd2258","ptime":"2017-12-23 09:30:24","img":"http://p4.img.cctvpic.com/fmspic/2017/12/23/a970037149ea4e9db395cc90fadd2258-21.jpg?p=2&h=120","len":"00:00:22","em":"CM01"},{"vsid":"VSET100167216881","order":"5735","vid":"7c134e3c20dc4770b9be03442ad3373a","t":"《精彩一刻》 20171223 \u201c戴丽\u201d：泡澡和打滚儿更配哦~","url":"http://tv.cntv.cn/video/VSET100167216881/7c134e3c20dc4770b9be03442ad3373a","ptime":"2017-12-23 09:29:30","img":"http://p2.img.cctvpic.com/fmspic/2017/12/23/7c134e3c20dc4770b9be03442ad3373a-31.jpg?p=2&h=120","len":"00:00:43","em":"CM01"},{"vsid":"VSET100167216881","order":"5733","vid":"5239d6f2af094ea8af3670047aa2b093","t":"《精彩一刻》 20171223 啃完护竹，这一顿就差不多了~","url":"http://tv.cntv.cn/video/VSET100167216881/5239d6f2af094ea8af3670047aa2b093","ptime":"2017-12-23 09:28:48","img":"http://p5.img.cctvpic.com/fmspic/2017/12/23/5239d6f2af094ea8af3670047aa2b093-31.jpg?p=2&h=120","len":"00:00:42","em":"CM01"},{"vsid":"VSET100167216881","order":"5732","vid":"36ea3c9ddb3e4efea3a73602efb57abd","t":"《精彩一刻》 20171223 \u201c蔓越煤\u201d：我孵出了一个蛋~","url":"http://tv.cntv.cn/video/VSET100167216881/36ea3c9ddb3e4efea3a73602efb57abd","ptime":"2017-12-23 09:28:01","img":"http://p5.img.cctvpic.com/fmspic/2017/12/23/36ea3c9ddb3e4efea3a73602efb57abd-9.jpg?p=2&h=120","len":"00:00:18","em":"CM01"},{"vsid":"VSET100167216881","order":"5734","vid":"b49496d2c9444ae39d5baa7ce4eae242","t":"《精彩一刻》 20171223 看我无敌电臀，请叫我熊届舞王","url":"http://tv.cntv.cn/video/VSET100167216881/b49496d2c9444ae39d5baa7ce4eae242","ptime":"2017-12-23 09:27:06","img":"http://p4.img.cctvpic.com/fmspic/2017/12/23/b49496d2c9444ae39d5baa7ce4eae242-22.jpg?p=2&h=120","len":"00:00:25","em":"CM01"}]
     */

    private VideosetBean videoset;
    private List<VideoBean> video;

    public VideosetBean getVideoset() {
        return videoset;
    }

    public void setVideoset(VideosetBean videoset) {
        this.videoset = videoset;
    }

    public List<VideoBean> getVideo() {
        return video;
    }

    public void setVideo(List<VideoBean> video) {
        this.video = video;
    }

    public static class VideosetBean {
        /**
         * 0 : {"vsid":"VSET100167216881","relvsid":"","name":"熊猫频道-精彩一刻","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100167216881","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"2013-05-01","sbpd":"其他","desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","playdesc":"","zcr":"","fcl":""}
         * count : 5724
         */

        @SerializedName("0")
        private _$0Bean _$0;
        private String count;

        public _$0Bean get_$0() {
            return _$0;
        }

        public void set_$0(_$0Bean _$0) {
            this._$0 = _$0;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public static class _$0Bean {
            /**
             * vsid : VSET100167216881
             * relvsid :
             * name : 熊猫频道-精彩一刻
             * img : http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg
             * enname : 其他
             * url : http://tv.cntv.cn/videoset/VSET100167216881
             * cd :
             * zy :
             * bj :
             * dy :
             * js :
             * nf :
             * yz :
             * fl :
             * sbsj : 2013-05-01
             * sbpd : 其他
             * desc : 精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。
             * playdesc :
             * zcr :
             * fcl :
             */

            private String vsid;
            private String relvsid;
            private String name;
            private String img;
            private String enname;
            private String url;
            private String cd;
            private String zy;
            private String bj;
            private String dy;
            private String js;
            private String nf;
            private String yz;
            private String fl;
            private String sbsj;
            private String sbpd;
            private String desc;
            private String playdesc;
            private String zcr;
            private String fcl;

            public String getVsid() {
                return vsid;
            }

            public void setVsid(String vsid) {
                this.vsid = vsid;
            }

            public String getRelvsid() {
                return relvsid;
            }

            public void setRelvsid(String relvsid) {
                this.relvsid = relvsid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getEnname() {
                return enname;
            }

            public void setEnname(String enname) {
                this.enname = enname;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getCd() {
                return cd;
            }

            public void setCd(String cd) {
                this.cd = cd;
            }

            public String getZy() {
                return zy;
            }

            public void setZy(String zy) {
                this.zy = zy;
            }

            public String getBj() {
                return bj;
            }

            public void setBj(String bj) {
                this.bj = bj;
            }

            public String getDy() {
                return dy;
            }

            public void setDy(String dy) {
                this.dy = dy;
            }

            public String getJs() {
                return js;
            }

            public void setJs(String js) {
                this.js = js;
            }

            public String getNf() {
                return nf;
            }

            public void setNf(String nf) {
                this.nf = nf;
            }

            public String getYz() {
                return yz;
            }

            public void setYz(String yz) {
                this.yz = yz;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getSbsj() {
                return sbsj;
            }

            public void setSbsj(String sbsj) {
                this.sbsj = sbsj;
            }

            public String getSbpd() {
                return sbpd;
            }

            public void setSbpd(String sbpd) {
                this.sbpd = sbpd;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPlaydesc() {
                return playdesc;
            }

            public void setPlaydesc(String playdesc) {
                this.playdesc = playdesc;
            }

            public String getZcr() {
                return zcr;
            }

            public void setZcr(String zcr) {
                this.zcr = zcr;
            }

            public String getFcl() {
                return fcl;
            }

            public void setFcl(String fcl) {
                this.fcl = fcl;
            }
        }
    }

    public static class VideoBean {
        /**
         * vsid : VSET100167216881
         * order : 5736
         * vid : 31f599df9e704307aa52e61fcba13596
         * t : 《精彩一刻》 20171223 我是个爱洗澡澡的宝宝~
         * url : http://tv.cntv.cn/video/VSET100167216881/31f599df9e704307aa52e61fcba13596
         * ptime : 2017-12-23 09:34:18
         * img : http://p5.img.cctvpic.com/fmspic/2017/12/23/31f599df9e704307aa52e61fcba13596-20.jpg?p=2&h=120
         * len : 00:00:20
         * em : CM01
         */

        private String vsid;
        private String order;
        private String vid;
        private String t;
        private String url;
        private String ptime;
        private String img;
        private String len;
        private String em;

        public String getVsid() {
            return vsid;
        }

        public void setVsid(String vsid) {
            this.vsid = vsid;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getLen() {
            return len;
        }

        public void setLen(String len) {
            this.len = len;
        }

        public String getEm() {
            return em;
        }

        public void setEm(String em) {
            this.em = em;
        }
    }
}
