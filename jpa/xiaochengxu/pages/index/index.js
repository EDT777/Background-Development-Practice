Page({
  data: {
    name: ''
  },
  //获取Java后台数据
  getData() {
    let that = this
    wx.request({
      url: 'http://localhost:8080/hello',
      success(res) {
        console.log("请求成功", res.data)
        that.setData({
          dataList: res.data
        })
      },
      fail(res) {
        console.log("请求失败", res)
      }
    })
  },
  //提交数据到java后台
  tijiao() {
    wx.request({
      url: 'http://localhost:8080/demo2',
      data: {
        age: 28
      },
      success(res) {
        console.log("上传数据成功", res)
      },
      fail(res) {
        console.log("上传数据失败", res)
      }
    })
  },
  //post提交数据到Java后台
  post() {
    wx.request({
      url: 'http://localhost:8080/demo3',
      method: "post",
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      data: {
        name: "编程小石头123"
      },
      success(res) {
        console.log("post上传数据成功", res)
      },
      fail(res) {
        console.log("post上传数据失败", res)
      }

    })
  },
  //获取用户输入的姓名
  inputName(event) {
    console.log(event.detail.value)
    this.setData({
      name: event.detail.value
    })
  },
  //提交用户输入的姓名
  postName() {
    let name2 = this.data.name
    if (name2.length < 2) {
      wx.showToast({
        icon: "none",
        title: '用户名太短',
      })
    } else {
      wx.request({
        url: 'http://localhost:8080/demo3',
        method: "post",
        header: {
          "Content-Type": "application/x-www-form-urlencoded"
        },
        data: {
          name: name2
        },
        success(res) {
          console.log("post上传数据成功", res)
        },
        fail(res) {
          console.log("post上传数据失败", res)
        }
      })
    }
  }

})