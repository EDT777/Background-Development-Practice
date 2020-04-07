package 连接;

import java.sql.Date;
import java.util.*;

public class Product {
		private Integer id;
		private String name;
		private Double price;
		@Override
		public String toString() {
			return "Product [id=" + id + ", name=" + name + ", price=" + price + ", createTime=" + createTime + "]";
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String i) {
			this.name = i;
		}
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}
		public Date getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}
		private Date createTime;
}
