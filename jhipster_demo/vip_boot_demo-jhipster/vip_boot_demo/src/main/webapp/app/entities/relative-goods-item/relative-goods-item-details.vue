<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="relativeGoodsItem">
                <h2 class="jh-entity-heading"><span v-text="$t('vip1App.relativeGoodsItem.detail.title')">RelativeGoodsItem</span> {{relativeGoodsItem.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('vip1App.relativeGoodsItem.platform')">Platform</span>
                    </dt>
                    <dd>
                        <span>{{relativeGoodsItem.platform}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.relativeGoodsItem.url')">Url</span>
                    </dt>
                    <dd>
                        <span>{{relativeGoodsItem.url}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.relativeGoodsItem.itemId')">Item Id</span>
                    </dt>
                    <dd>
                        <span>{{relativeGoodsItem.itemId}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.relativeGoodsItem.translated')">Translated</span>
                    </dt>
                    <dd>
                        <span>{{relativeGoodsItem.translated}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.relativeGoodsItem.translatedUrl')">Translated Url</span>
                    </dt>
                    <dd>
                        <span>{{relativeGoodsItem.translatedUrl}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.relativeGoodsItem.mainImage')">Main Image</span>
                    </dt>
                    <dd>
                        <span>{{relativeGoodsItem.mainImage}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.relativeGoodsItem.smallImages')">Small Images</span>
                    </dt>
                    <dd>
                        <span>{{relativeGoodsItem.smallImages}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.relativeGoodsItem.title')">Title</span>
                    </dt>
                    <dd>
                        <span>{{relativeGoodsItem.title}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.relativeGoodsItem.shopName')">Shop Name</span>
                    </dt>
                    <dd>
                        <span>{{relativeGoodsItem.shopName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.relativeGoodsItem.sellCount')">Sell Count</span>
                    </dt>
                    <dd>
                        <span>{{relativeGoodsItem.sellCount}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.relativeGoodsItem.price')">Price</span>
                    </dt>
                    <dd>
                        <span>{{relativeGoodsItem.price}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.relativeGoodsItem.zkPrice')">Zk Price</span>
                    </dt>
                    <dd>
                        <span>{{relativeGoodsItem.zkPrice}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.relativeGoodsItem.commssion')">Commssion</span>
                    </dt>
                    <dd>
                        <span>{{relativeGoodsItem.commssion}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.relativeGoodsItem.commssionRate')">Commssion Rate</span>
                    </dt>
                    <dd>
                        <span>{{relativeGoodsItem.commssionRate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.relativeGoodsItem.description')">Description</span>
                    </dt>
                    <dd>
                        <span>{{relativeGoodsItem.description}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.relativeGoodsItem.coupon')">Coupon</span>
                    </dt>
                    <dd>
                        <span>{{relativeGoodsItem.coupon}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.relativeGoodsItem.streamItem')">Stream Item</span>
                    </dt>
                    <dd>
                        <div v-if="relativeGoodsItem.streamItemId">
                            <router-link :to="{name: 'InfoStreamItemView', params: {infoStreamItemId: relativeGoodsItem.streamItemId}}">{{relativeGoodsItem.streamItemId}}</router-link>
                        </div>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.relativeGoodsItem.infoStreamItem')">Info Stream Item</span>
                    </dt>
                    <dd>
                        <div v-if="relativeGoodsItem.infoStreamItemId">
                            <router-link :to="{name: 'InfoStreamItemView', params: {infoStreamItemId: relativeGoodsItem.infoStreamItemId}}">{{relativeGoodsItem.infoStreamItemId}}</router-link>
                        </div>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="relativeGoodsItem.id" :to="{name: 'RelativeGoodsItemEdit', params: {relativeGoodsItemId: relativeGoodsItem.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./relative-goods-item-details.component.ts">
</script>
