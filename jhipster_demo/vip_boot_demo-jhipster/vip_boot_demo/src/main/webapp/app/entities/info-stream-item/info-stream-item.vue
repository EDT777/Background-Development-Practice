<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('vip1App.infoStreamItem.home.title')" id="info-stream-item-heading">Info Stream Items</span>
            <router-link :to="{name: 'InfoStreamItemCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-info-stream-item">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('vip1App.infoStreamItem.home.createLabel')">
                    Create a new Info Stream Item
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
        <div class="alert alert-warning" v-if="!isFetching && infoStreamItems && infoStreamItems.length === 0">
            <span v-text="$t('vip1App.infoStreamItem.home.notFound')">No infoStreamItems found</span>
        </div>
        <div class="table-responsive" v-if="infoStreamItems && infoStreamItems.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('title')"><span v-text="$t('vip1App.infoStreamItem.title')">Title</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'title'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('type')"><span v-text="$t('vip1App.infoStreamItem.type')">Type</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'type'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('digist')"><span v-text="$t('vip1App.infoStreamItem.digist')">Digist</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'digist'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('content')"><span v-text="$t('vip1App.infoStreamItem.content')">Content</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'content'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('createUser')"><span v-text="$t('vip1App.infoStreamItem.createUser')">Create User</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createUser'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('lastUpdateDate')"><span v-text="$t('vip1App.infoStreamItem.lastUpdateDate')">Last Update Date</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lastUpdateDate'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('updateUser')"><span v-text="$t('vip1App.infoStreamItem.updateUser')">Update User</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateUser'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('createDate')"><span v-text="$t('vip1App.infoStreamItem.createDate')">Create Date</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createDate'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('tags')"><span v-text="$t('vip1App.infoStreamItem.tags')">Tags</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tags'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('contentType')"><span v-text="$t('vip1App.infoStreamItem.contentType')">Content Type</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'contentType'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('authorId')"><span v-text="$t('vip1App.infoStreamItem.author')">Author</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'authorId'"></jhi-sort-indicator></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="infoStreamItem in infoStreamItems"
                    :key="infoStreamItem.id">
                    <td>
                        <router-link :to="{name: 'InfoStreamItemView', params: {infoStreamItemId: infoStreamItem.id}}">{{infoStreamItem.id}}</router-link>
                    </td>
                    <td>{{infoStreamItem.title}}</td>
                    <td>{{infoStreamItem.type}}</td>
                    <td>{{infoStreamItem.digist}}</td>
                    <td>{{infoStreamItem.content}}</td>
                    <td>{{infoStreamItem.createUser}}</td>
                    <td>{{infoStreamItem.lastUpdateDate ? $d(Date.parse(infoStreamItem.lastUpdateDate), 'short') : ''}}</td>
                    <td>{{infoStreamItem.updateUser}}</td>
                    <td>{{infoStreamItem.createDate ? $d(Date.parse(infoStreamItem.createDate), 'short') : ''}}</td>
                    <td>{{infoStreamItem.tags}}</td>
                    <td v-text="$t('vip1App.ItemResourceType.' + infoStreamItem.contentType)">{{infoStreamItem.contentType}}</td>
                    <td>
                        <div v-if="infoStreamItem.authorId">
                            <router-link :to="{name: 'AuthorView', params: {authorId: infoStreamItem.authorId}}">{{infoStreamItem.authorId}}</router-link>
                        </div>
                    </td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'InfoStreamItemView', params: {infoStreamItemId: infoStreamItem.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'InfoStreamItemEdit', params: {infoStreamItemId: infoStreamItem.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(infoStreamItem)"
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
            <span slot="modal-title"><span id="vip1App.infoStreamItem.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-infoStreamItem-heading" v-text="$t('vip1App.infoStreamItem.delete.question', {'id': removeId})">Are you sure you want to delete this Info Stream Item?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-infoStreamItem" v-text="$t('entity.action.delete')" v-on:click="removeInfoStreamItem()">Delete</button>
            </div>
        </b-modal>
        <div v-show="infoStreamItems && infoStreamItems.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./info-stream-item.component.ts">
</script>
