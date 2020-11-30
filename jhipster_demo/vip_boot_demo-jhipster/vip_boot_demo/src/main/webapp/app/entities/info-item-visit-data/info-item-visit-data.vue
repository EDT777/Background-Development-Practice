<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('vip1App.infoItemVisitData.home.title')" id="info-item-visit-data-heading">Info Item Visit Data</span>
            <router-link :to="{name: 'InfoItemVisitDataCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-info-item-visit-data">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('vip1App.infoItemVisitData.home.createLabel')">
                    Create a new Info Item Visit Data
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
        <div class="alert alert-warning" v-if="!isFetching && infoItemVisitData && infoItemVisitData.length === 0">
            <span v-text="$t('vip1App.infoItemVisitData.home.notFound')">No infoItemVisitData found</span>
        </div>
        <div class="table-responsive" v-if="infoItemVisitData && infoItemVisitData.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('userId')"><span v-text="$t('vip1App.infoItemVisitData.userId')">User Id</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'userId'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('deviceNo')"><span v-text="$t('vip1App.infoItemVisitData.deviceNo')">Device No</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'deviceNo'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('date')"><span v-text="$t('vip1App.infoItemVisitData.date')">Date</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'date'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('source')"><span v-text="$t('vip1App.infoItemVisitData.source')">Source</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'source'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('action')"><span v-text="$t('vip1App.infoItemVisitData.action')">Action</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'action'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('goods')"><span v-text="$t('vip1App.infoItemVisitData.goods')">Goods</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'goods'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('termimal')"><span v-text="$t('vip1App.infoItemVisitData.termimal')">Termimal</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'termimal'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('streamItemId')"><span v-text="$t('vip1App.infoItemVisitData.streamItem')">Stream Item</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'streamItemId'"></jhi-sort-indicator></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="infoItemVisitData in infoItemVisitData"
                    :key="infoItemVisitData.id">
                    <td>
                        <router-link :to="{name: 'InfoItemVisitDataView', params: {infoItemVisitDataId: infoItemVisitData.id}}">{{infoItemVisitData.id}}</router-link>
                    </td>
                    <td>{{infoItemVisitData.userId}}</td>
                    <td>{{infoItemVisitData.deviceNo}}</td>
                    <td>{{infoItemVisitData.date}}</td>
                    <td v-text="$t('vip1App.VisitSource.' + infoItemVisitData.source)">{{infoItemVisitData.source}}</td>
                    <td>{{infoItemVisitData.action}}</td>
                    <td>{{infoItemVisitData.goods}}</td>
                    <td>{{infoItemVisitData.termimal}}</td>
                    <td>
                        <div v-if="infoItemVisitData.streamItemId">
                            <router-link :to="{name: 'InfoStreamItemView', params: {infoStreamItemId: infoItemVisitData.streamItemId}}">{{infoItemVisitData.streamItemId}}</router-link>
                        </div>
                    </td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'InfoItemVisitDataView', params: {infoItemVisitDataId: infoItemVisitData.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'InfoItemVisitDataEdit', params: {infoItemVisitDataId: infoItemVisitData.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(infoItemVisitData)"
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
            <span slot="modal-title"><span id="vip1App.infoItemVisitData.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-infoItemVisitData-heading" v-text="$t('vip1App.infoItemVisitData.delete.question', {'id': removeId})">Are you sure you want to delete this Info Item Visit Data?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-infoItemVisitData" v-text="$t('entity.action.delete')" v-on:click="removeInfoItemVisitData()">Delete</button>
            </div>
        </b-modal>
        <div v-show="infoItemVisitData && infoItemVisitData.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./info-item-visit-data.component.ts">
</script>
