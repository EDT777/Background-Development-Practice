<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('vip1App.resourceItem.home.title')" id="resource-item-heading">Resource Items</span>
            <router-link :to="{name: 'ResourceItemCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-resource-item">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('vip1App.resourceItem.home.createLabel')">
                    Create a new Resource Item
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
        <div class="alert alert-warning" v-if="!isFetching && resourceItems && resourceItems.length === 0">
            <span v-text="$t('vip1App.resourceItem.home.notFound')">No resourceItems found</span>
        </div>
        <div class="table-responsive" v-if="resourceItems && resourceItems.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('type')"><span v-text="$t('vip1App.resourceItem.type')">Type</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'type'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('platform')"><span v-text="$t('vip1App.resourceItem.platform')">Platform</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'platform'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('resourceId')"><span v-text="$t('vip1App.resourceItem.resourceId')">Resource Id</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resourceId'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('transcodeStatus')"><span v-text="$t('vip1App.resourceItem.transcodeStatus')">Transcode Status</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'transcodeStatus'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('uploadStatus')"><span v-text="$t('vip1App.resourceItem.uploadStatus')">Upload Status</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'uploadStatus'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('updateDate')"><span v-text="$t('vip1App.resourceItem.updateDate')">Update Date</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateDate'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('auditStatus')"><span v-text="$t('vip1App.resourceItem.auditStatus')">Audit Status</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'auditStatus'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('auditDate')"><span v-text="$t('vip1App.resourceItem.auditDate')">Audit Date</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'auditDate'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('auditInfo')"><span v-text="$t('vip1App.resourceItem.auditInfo')">Audit Info</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'auditInfo'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('fileSize')"><span v-text="$t('vip1App.resourceItem.fileSize')">File Size</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fileSize'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('contentSize')"><span v-text="$t('vip1App.resourceItem.contentSize')">Content Size</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'contentSize'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('source')"><span v-text="$t('vip1App.resourceItem.source')">Source</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'source'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('url')"><span v-text="$t('vip1App.resourceItem.url')">Url</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'url'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('urlExpire')"><span v-text="$t('vip1App.resourceItem.urlExpire')">Url Expire</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'urlExpire'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('params')"><span v-text="$t('vip1App.resourceItem.params')">Params</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'params'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('auditUser')"><span v-text="$t('vip1App.resourceItem.auditUser')">Audit User</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'auditUser'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('delFlag')"><span v-text="$t('vip1App.resourceItem.delFlag')">Del Flag</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'delFlag'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('infoStreamItemId')"><span v-text="$t('vip1App.resourceItem.infoStreamItem')">Info Stream Item</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'infoStreamItemId'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('infoStreamItemId')"><span v-text="$t('vip1App.resourceItem.infoStreamItem')">Info Stream Item</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'infoStreamItemId'"></jhi-sort-indicator></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="resourceItem in resourceItems"
                    :key="resourceItem.id">
                    <td>
                        <router-link :to="{name: 'ResourceItemView', params: {resourceItemId: resourceItem.id}}">{{resourceItem.id}}</router-link>
                    </td>
                    <td v-text="$t('vip1App.ItemResourceType.' + resourceItem.type)">{{resourceItem.type}}</td>
                    <td>{{resourceItem.platform}}</td>
                    <td>{{resourceItem.resourceId}}</td>
                    <td>{{resourceItem.transcodeStatus}}</td>
                    <td>{{resourceItem.uploadStatus}}</td>
                    <td>{{resourceItem.updateDate ? $d(Date.parse(resourceItem.updateDate), 'short') : ''}}</td>
                    <td>{{resourceItem.auditStatus}}</td>
                    <td>{{resourceItem.auditDate ? $d(Date.parse(resourceItem.auditDate), 'short') : ''}}</td>
                    <td>{{resourceItem.auditInfo}}</td>
                    <td>{{resourceItem.fileSize}}</td>
                    <td>{{resourceItem.contentSize}}</td>
                    <td>{{resourceItem.source}}</td>
                    <td>{{resourceItem.url}}</td>
                    <td>{{resourceItem.urlExpire}}</td>
                    <td>{{resourceItem.params}}</td>
                    <td>{{resourceItem.auditUser}}</td>
                    <td>{{resourceItem.delFlag}}</td>
                    <td>
                        <div v-if="resourceItem.infoStreamItemId">
                            <router-link :to="{name: 'InfoStreamItemView', params: {infoStreamItemId: resourceItem.infoStreamItemId}}">{{resourceItem.infoStreamItemId}}</router-link>
                        </div>
                    </td>
                    <td>
                        <div v-if="resourceItem.infoStreamItemId">
                            <router-link :to="{name: 'InfoStreamItemView', params: {infoStreamItemId: resourceItem.infoStreamItemId}}">{{resourceItem.infoStreamItemId}}</router-link>
                        </div>
                    </td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'ResourceItemView', params: {resourceItemId: resourceItem.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'ResourceItemEdit', params: {resourceItemId: resourceItem.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(resourceItem)"
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
            <span slot="modal-title"><span id="vip1App.resourceItem.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-resourceItem-heading" v-text="$t('vip1App.resourceItem.delete.question', {'id': removeId})">Are you sure you want to delete this Resource Item?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-resourceItem" v-text="$t('entity.action.delete')" v-on:click="removeResourceItem()">Delete</button>
            </div>
        </b-modal>
        <div v-show="resourceItems && resourceItems.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./resource-item.component.ts">
</script>
