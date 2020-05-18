let a = 0;
let b = 0;
Page({
  data: {
    result: ''
  },
  //获取用户输入的a
  getA(e) {
    a = e.detail.value
  },
  //获取用户输入的b
  getB(event) {
    b = event.detail.value
  },
  //提交计算
  add() {
    console.log(a, b)
    let that = this
    wx.request({
      url: 'http://localhost:8080/demo4',
      method: "post",
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      data: {
        a: a,
        b: b
      },
      success(res) {
        console.log("计算成功", res)
        that.setData({
          result: res.data
        })
      },
      fail(res) {
        console.log("计算失败", res)
      }
    })
  }
})