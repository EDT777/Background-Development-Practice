let id, name, age, address

Page({
  //获取用户输入的id
  getId(event) {
    id = event.detail.value
    console.log(event.detail.value)
  },
  //获取用户输入的姓名
  getName(event) {
    name = event.detail.value
  },
  //获取用户输入的年龄
  getAge(event) {
    age = event.detail.value
  },
  //获取用户输入的地址
  getAddress(event) {
    address = event.detail.value
  },
  //增和改
  addAndUpdate() {
    console.log(id, name, age, address)
    wx.request({
      url: 'http://localhost:8080/add',
      method: "get",
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      data: {
        id,
        name,
        age,
        address
      },
      success(res) {
        console.log("添加成功", res)
        if (res.statusCode == 200) {
          wx.showToast({
            title: '操作成功'
          })
        } else {
          wx.showToast({
            icon: "none",
            title: '操作失败'
          })
        }
      },
      fail(res) {
        console.log("添加失败", res)
      }
    })
  },
  //删除
  delete() {
    if (id) {
      wx.request({
        url: 'http://localhost:8080/deleteOne',
        method: "get",
        header: {
          "Content-Type": "application/x-www-form-urlencoded"
        },
        data: {
          id
        },
        success(res) {
          console.log("删除成功", res)
          if (res.statusCode == 200) {
            wx.showToast({
              title: '删除成功'
            })
          } else {
            wx.showToast({
              icon: "none",
              title: '删除失败'
            })
          }
        },
        fail(res) {
          console.log("删除失败", res)
        }
      })
    } else {
      wx.showToast({
        icon: 'none',
        title: '请输入id',
      })
    }
  },
  //查
  getAll() {
    let that=this
    wx.request({
      url: 'http://localhost:8080/getAll',
      method: "get",
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success(res) {
        console.log("查询成功", res.data)
        if (res.statusCode == 200) {
          that.setData({
            datalist: res.data
          })
        } else {
          wx.showToast({
            icon: "none",
            title: '查询失败'
          })
        }
      },
      fail(res) {
        console.log("查询失败", res)
      }
    })

  },
})