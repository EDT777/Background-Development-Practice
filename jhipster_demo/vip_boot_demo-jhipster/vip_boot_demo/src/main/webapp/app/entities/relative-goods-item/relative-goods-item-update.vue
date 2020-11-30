<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="vip1App.relativeGoodsItem.home.createOrEditLabel" v-text="$t('vip1App.relativeGoodsItem.home.createOrEditLabel')">Create or edit a RelativeGoodsItem</h2>
                <div>
                    <div class="form-group" v-if="relativeGoodsItem.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="relativeGoodsItem.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.relativeGoodsItem.platform')" for="relative-goods-item-platform">Platform</label>
                        <input type="text" class="form-control" name="platform" id="relative-goods-item-platform"
                            :class="{'valid': !$v.relativeGoodsItem.platform.$invalid, 'invalid': $v.relativeGoodsItem.platform.$invalid }" v-model="$v.relativeGoodsItem.platform.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.relativeGoodsItem.url')" for="relative-goods-item-url">Url</label>
                        <input type="text" class="form-control" name="url" id="relative-goods-item-url"
                            :class="{'valid': !$v.relativeGoodsItem.url.$invalid, 'invalid': $v.relativeGoodsItem.url.$invalid }" v-model="$v.relativeGoodsItem.url.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.relativeGoodsItem.itemId')" for="relative-goods-item-itemId">Item Id</label>
                        <input type="text" class="form-control" name="itemId" id="relative-goods-item-itemId"
                            :class="{'valid': !$v.relativeGoodsItem.itemId.$invalid, 'invalid': $v.relativeGoodsItem.itemId.$invalid }" v-model="$v.relativeGoodsItem.itemId.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.relativeGoodsItem.translated')" for="relative-goods-item-translated">Translated</label>
                        <input type="checkbox" class="form-check" name="translated" id="relative-goods-item-translated"
                            :class="{'valid': !$v.relativeGoodsItem.translated.$invalid, 'invalid': $v.relativeGoodsItem.translated.$invalid }" v-model="$v.relativeGoodsItem.translated.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.relativeGoodsItem.translatedUrl')" for="relative-goods-item-translatedUrl">Translated Url</label>
                        <input type="text" class="form-control" name="translatedUrl" id="relative-goods-item-translatedUrl"
                            :class="{'valid': !$v.relativeGoodsItem.translatedUrl.$invalid, 'invalid': $v.relativeGoodsItem.translatedUrl.$invalid }" v-model="$v.relativeGoodsItem.translatedUrl.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.relativeGoodsItem.mainImage')" for="relative-goods-item-mainImage">Main Image</label>
                        <input type="text" class="form-control" name="mainImage" id="relative-goods-item-mainImage"
                            :class="{'valid': !$v.relativeGoodsItem.mainImage.$invalid, 'invalid': $v.relativeGoodsItem.mainImage.$invalid }" v-model="$v.relativeGoodsItem.mainImage.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.relativeGoodsItem.smallImages')" for="relative-goods-item-smallImages">Small Images</label>
                        <input type="text" class="form-control" name="smallImages" id="relative-goods-item-smallImages"
                            :class="{'valid': !$v.relativeGoodsItem.smallImages.$invalid, 'invalid': $v.relativeGoodsItem.smallImages.$invalid }" v-model="$v.relativeGoodsItem.smallImages.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.relativeGoodsItem.title')" for="relative-goods-item-title">Title</label>
                        <input type="text" class="form-control" name="title" id="relative-goods-item-title"
                            :class="{'valid': !$v.relativeGoodsItem.title.$invalid, 'invalid': $v.relativeGoodsItem.title.$invalid }" v-model="$v.relativeGoodsItem.title.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.relativeGoodsItem.shopName')" for="relative-goods-item-shopName">Shop Name</label>
                        <input type="text" class="form-control" name="shopName" id="relative-goods-item-shopName"
                            :class="{'valid': !$v.relativeGoodsItem.shopName.$invalid, 'invalid': $v.relativeGoodsItem.shopName.$invalid }" v-model="$v.relativeGoodsItem.shopName.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.relativeGoodsItem.sellCount')" for="relative-goods-item-sellCount">Sell Count</label>
                        <input type="number" class="form-control" name="sellCount" id="relative-goods-item-sellCount"
                            :class="{'valid': !$v.relativeGoodsItem.sellCount.$invalid, 'invalid': $v.relativeGoodsItem.sellCount.$invalid }" v-model.number="$v.relativeGoodsItem.sellCount.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.relativeGoodsItem.price')" for="relative-goods-item-price">Price</label>
                        <input type="number" class="form-control" name="price" id="relative-goods-item-price"
                            :class="{'valid': !$v.relativeGoodsItem.price.$invalid, 'invalid': $v.relativeGoodsItem.price.$invalid }" v-model.number="$v.relativeGoodsItem.price.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.relativeGoodsItem.zkPrice')" for="relative-goods-item-zkPrice">Zk Price</label>
                        <input type="number" class="form-control" name="zkPrice" id="relative-goods-item-zkPrice"
                            :class="{'valid': !$v.relativeGoodsItem.zkPrice.$invalid, 'invalid': $v.relativeGoodsItem.zkPrice.$invalid }" v-model.number="$v.relativeGoodsItem.zkPrice.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.relativeGoodsItem.commssion')" for="relative-goods-item-commssion">Commssion</label>
                        <input type="number" class="form-control" name="commssion" id="relative-goods-item-commssion"
                            :class="{'valid': !$v.relativeGoodsItem.commssion.$invalid, 'invalid': $v.relativeGoodsItem.commssion.$invalid }" v-model.number="$v.relativeGoodsItem.commssion.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.relativeGoodsItem.commssionRate')" for="relative-goods-item-commssionRate">Commssion Rate</label>
                        <input type="number" class="form-control" name="commssionRate" id="relative-goods-item-commssionRate"
                            :class="{'valid': !$v.relativeGoodsItem.commssionRate.$invalid, 'invalid': $v.relativeGoodsItem.commssionRate.$invalid }" v-model.number="$v.relativeGoodsItem.commssionRate.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.relativeGoodsItem.description')" for="relative-goods-item-description">Description</label>
                        <input type="text" class="form-control" name="description" id="relative-goods-item-description"
                            :class="{'valid': !$v.relativeGoodsItem.description.$invalid, 'invalid': $v.relativeGoodsItem.description.$invalid }" v-model="$v.relativeGoodsItem.description.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.relativeGoodsItem.coupon')" for="relative-goods-item-coupon">Coupon</label>
                        <input type="number" class="form-control" name="coupon" id="relative-goods-item-coupon"
                            :class="{'valid': !$v.relativeGoodsItem.coupon.$invalid, 'invalid': $v.relativeGoodsItem.coupon.$invalid }" v-model.number="$v.relativeGoodsItem.coupon.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.relativeGoodsItem.streamItem')" for="relative-goods-item-streamItem">Stream Item</label>
                        <select class="form-control" id="relative-goods-item-streamItem" name="streamItem" v-model="relativeGoodsItem.streamItemId">
                            <option v-bind:value="null"></option>
                            <option v-bind:value="infoStreamItemOption.id" v-for="infoStreamItemOption in infoStreamItems" :key="infoStreamItemOption.id">{{infoStreamItemOption.id}}</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.relativeGoodsItem.infoStreamItem')" for="relative-goods-item-infoStreamItem">Info Stream Item</label>
                        <select class="form-control" id="relative-goods-item-infoStreamItem" name="infoStreamItem" v-model="relativeGoodsItem.infoStreamItemId">
                            <option v-bind:value="null"></option>
                            <option v-bind:value="infoStreamItemOption.id" v-for="infoStreamItemOption in infoStreamItems" :key="infoStreamItemOption.id">{{infoStreamItemOption.id}}</option>
                        </select>
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.relativeGoodsItem.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./relative-goods-item-update.component.ts">
</script>
