<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('vip1App.streamItemStarData.home.title')" id="stream-item-star-data-heading">Stream Item Star Data</span>
            <router-link :to="{name: 'StreamItemStarDataCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-stream-item-star-data">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('vip1App.streamItemStarData.home.createLabel')">
                    Create a new Stream Item Star Data
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
        <div class="alert alert-warning" v-if="!isFetching && streamItemStarData && streamItemStarData.length === 0">
            <span v-text="$t('vip1App.streamItemStarData.home.notFound')">No streamItemStarData found</span>
        </div>
        <div class="table-responsive" v-if="streamItemStarData && streamItemStarData.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('userId')"><span v-text="$t('vip1App.streamItemStarData.userId')">User Id</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'userId'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('createDate')"><span v-text="$t('vip1App.streamItemStarData.createDate')">Create Date</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createDate'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('type')"><span v-text="$t('vip1App.streamItemStarData.type')">Type</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'type'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('itemId')"><span v-text="$t('vip1App.streamItemStarData.itemId')">Item Id</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'itemId'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('replayId')"><span v-text="$t('vip1App.streamItemStarData.replayId')">Replay Id</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'replayId'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('valid')"><span v-text="$t('vip1App.streamItemStarData.valid')">Valid</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'valid'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('starType')"><span v-text="$t('vip1App.streamItemStarData.starType')">Star Type</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'starType'"></jhi-sort-indicator></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="streamItemStarData in streamItemStarData"
                    :key="streamItemStarData.id">
                    <td>
                        <router-link :to="{name: 'StreamItemStarDataView', params: {streamItemStarDataId: streamItemStarData.id}}">{{streamItemStarData.id}}</router-link>
                    </td>
                    <td>{{streamItemStarData.userId}}</td>
                    <td>{{streamItemStarData.createDate ? $d(Date.parse(streamItemStarData.createDate), 'short') : ''}}</td>
                    <td>{{streamItemStarData.type}}</td>
                    <td>{{streamItemStarData.itemId}}</td>
                    <td>{{streamItemStarData.replayId}}</td>
                    <td>{{streamItemStarData.valid}}</td>
                    <td>{{streamItemStarData.starType}}</td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'StreamItemStarDataView', params: {streamItemStarDataId: streamItemStarData.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'StreamItemStarDataEdit', params: {streamItemStarDataId: streamItemStarData.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(streamItemStarData)"
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
            <span slot="modal-title"><span id="vip1App.streamItemStarData.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-streamItemStarData-heading" v-text="$t('vip1App.streamItemStarData.delete.question', {'id': removeId})">Are you sure you want to delete this Stream Item Star Data?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-streamItemStarData" v-text="$t('entity.action.delete')" v-on:click="removeStreamItemStarData()">Delete</button>
            </div>
        </b-modal>
        <div v-show="streamItemStarData && streamItemStarData.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./stream-item-star-data.component.ts">
</script>
