// pages/list/list.js
Page({
  data: {
    dataList: []
  },
  onLoad: function(options) {
    let that = this
    wx.request({
      url: 'http://localhost:8080/getList',
      success(res) {
        console.log("成功", res.data)
        that.setData({
          dataList: res.data
        })
      },
      fail(res) {
        console.log("失败", res)
      }
    })
  },
})