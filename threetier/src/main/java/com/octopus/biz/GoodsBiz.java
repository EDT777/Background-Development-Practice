package com.octopus.biz;

import java.util.List;

import com.octopus.entiy.Goods;

public interface GoodsBiz {
		public List<Goods> query(String keyword);
}
