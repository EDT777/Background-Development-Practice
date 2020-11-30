<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('vip1App.relativeGoodsItem.home.title')" id="relative-goods-item-heading">Relative Goods Items</span>
            <router-link :to="{name: 'RelativeGoodsItemCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-relative-goods-item">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('vip1App.relativeGoodsItem.home.createLabel')">
                    Create a new Relative Goods Item
                </span>
            </router-link>
        </h2>
        <b-alert :show="dismissCountDown"
            dismissible
            :variant="alertType"
            @dismissed="dismissCountDown=0"
            @dismiss-count-down="countDownChanged">
            {{alertMessage}}
        </b-alert>
        <br/>
        <div class="alert alert-warning" v-if="!isFetching && relativeGoodsItems && relativeGoodsItems.length === 0">
            <span v-text="$t('vip1App.relativeGoodsItem.home.notFound')">No relativeGoodsItems found</span>
        </div>
        <div class="table-responsive" v-if="relativeGoodsItems && relativeGoodsItems.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('platform')"><span v-text="$t('vip1App.relativeGoodsItem.platform')">Platform</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'platform'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('url')"><span v-text="$t('vip1App.relativeGoodsItem.url')">Url</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'url'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('itemId')"><span v-text="$t('vip1App.relativeGoodsItem.itemId')">Item Id</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'itemId'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('translated')"><span v-text="$t('vip1App.relativeGoodsItem.translated')">Translated</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'translated'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('translatedUrl')"><span v-text="$t('vip1App.relativeGoodsItem.translatedUrl')">Translated Url</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'translatedUrl'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('mainImage')"><span v-text="$t('vip1App.relativeGoodsItem.mainImage')">Main Image</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'mainImage'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('smallImages')"><span v-text="$t('vip1App.relativeGoodsItem.smallImages')">Small Images</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'smallImages'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('title')"><span v-text="$t('vip1App.relativeGoodsItem.title')">Title</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'title'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('shopName')"><span v-text="$t('vip1App.relativeGoodsItem.shopName')">Shop Name</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'shopName'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('sellCount')"><span v-text="$t('vip1App.relativeGoodsItem.sellCount')">Sell Count</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sellCount'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('price')"><span v-text="$t('vip1App.relativeGoodsItem.price')">Price</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'price'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('zkPrice')"><span v-text="$t('vip1App.relativeGoodsItem.zkPrice')">Zk Price</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'zkPrice'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('commssion')"><span v-text="$t('vip1App.relativeGoodsItem.commssion')">Commssion</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'commssion'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('commssionRate')"><span v-text="$t('vip1App.relativeGoodsItem.commssionRate')">Commssion Rate</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'commssionRate'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('description')"><span v-text="$t('vip1App.relativeGoodsItem.description')">Description</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'description'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('coupon')"><span v-text="$t('vip1App.relativeGoodsItem.coupon')">Coupon</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'coupon'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('streamItemId')"><span v-text="$t('vip1App.relativeGoodsItem.streamItem')">Stream Item</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'streamItemId'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('infoStreamItemId')"><span v-text="$t('vip1App.relativeGoodsItem.infoStreamItem')">Info Stream Item</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'infoStreamItemId'"></jhi-sort-indicator></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="relativeGoodsItem in relativeGoodsItems"
                    :key="relativeGoodsItem.id">
                    <td>
                        <router-link :to="{name: 'RelativeGoodsItemView', params: {relativeGoodsItemId: relativeGoodsItem.id}}">{{relativeGoodsItem.id}}</router-link>
                    </td>
                    <td>{{relativeGoodsItem.platform}}</td>
                    <td>{{relativeGoodsItem.url}}</td>
                    <td>{{relativeGoodsItem.itemId}}</td>
                    <td>{{relativeGoodsItem.translated}}</td>
                    <td>{{relativeGoodsItem.translatedUrl}}</td>
                    <td>{{relativeGoodsItem.mainImage}}</td>
                    <td>{{relativeGoodsItem.smallImages}}</td>
                    <td>{{relativeGoodsItem.title}}</td>
                    <td>{{relativeGoodsItem.shopName}}</td>
                    <td>{{relativeGoodsItem.sellCount}}</td>
                    <td>{{relativeGoodsItem.price}}</td>
                    <td>{{relativeGoodsItem.zkPrice}}</td>
                    <td>{{relativeGoodsItem.commssion}}</td>
                    <td>{{relativeGoodsItem.commssionRate}}</td>
                    <td>{{relativeGoodsItem.description}}</td>
                    <td>{{relativeGoodsItem.coupon}}</td>
                    <td>
                        <div v-if="relativeGoodsItem.streamItemId">
                            <router-link :to="{name: 'InfoStreamItemView', params: {infoStreamItemId: relativeGoodsItem.streamItemId}}">{{relativeGoodsItem.streamItemId}}</router-link>
                        </div>
                    </td>
                    <td>
                        <div v-if="relativeGoodsItem.infoStreamItemId">
                            <router-link :to="{name: 'InfoStreamItemView', params: {infoStreamItemId: relativeGoodsItem.infoStreamItemId}}">{{relativeGoodsItem.infoStreamItemId}}</router-link>
                        </div>
                    </td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'RelativeGoodsItemView', params: {relativeGoodsItemId: relativeGoodsItem.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'RelativeGoodsItemEdit', params: {relativeGoodsItemId: relativeGoodsItem.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(relativeGoodsItem)"
                                   variant="danger"
                                   class="btn btn-sm"
                                   v-b-modal.removeEntity>
                                <font-awesome-icon icon="times"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.delete')">Delete</span>
                            </b-button>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <b-modal ref="removeEntity" id="removeEntity" >
            <span slot="modal-title"><span id="vip1App.relativeGoodsItem.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-relativeGoodsItem-heading" v-text="$t('vip1App.relativeGoodsItem.delete.question', {'id': removeId})">Are you sure you want to delete this Relative Goods Item?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-relativeGoodsItem" v-text="$t('entity.action.delete')" v-on:click="removeRelativeGoodsItem()">Delete</button>
            </div>
        </b-modal>
        <div v-show="relativeGoodsItems && relativeGoodsItems.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./relative-goods-item.component.ts">
</script>
