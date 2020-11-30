<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('vip1App.userContentCollection.home.title')" id="user-content-collection-heading">User Content Collections</span>
            <router-link :to="{name: 'UserContentCollectionCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-user-content-collection">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('vip1App.userContentCollection.home.createLabel')">
                    Create a new User Content Collection
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
        <div class="alert alert-warning" v-if="!isFetching && userContentCollections && userContentCollections.length === 0">
            <span v-text="$t('vip1App.userContentCollection.home.notFound')">No userContentCollections found</span>
        </div>
        <div class="table-responsive" v-if="userContentCollections && userContentCollections.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('userId')"><span v-text="$t('vip1App.userContentCollection.userId')">User Id</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'userId'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('platform')"><span v-text="$t('vip1App.userContentCollection.platform')">Platform</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'platform'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('link')"><span v-text="$t('vip1App.userContentCollection.link')">Link</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'link'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('createDate')"><span v-text="$t('vip1App.userContentCollection.createDate')">Create Date</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createDate'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('pctUrl')"><span v-text="$t('vip1App.userContentCollection.pctUrl')">Pct Url</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'pctUrl'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('valid')"><span v-text="$t('vip1App.userContentCollection.valid')">Valid</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'valid'"></jhi-sort-indicator></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="userContentCollection in userContentCollections"
                    :key="userContentCollection.id">
                    <td>
                        <router-link :to="{name: 'UserContentCollectionView', params: {userContentCollectionId: userContentCollection.id}}">{{userContentCollection.id}}</router-link>
                    </td>
                    <td>{{userContentCollection.userId}}</td>
                    <td>{{userContentCollection.platform}}</td>
                    <td>{{userContentCollection.link}}</td>
                    <td>{{userContentCollection.createDate ? $d(Date.parse(userContentCollection.createDate), 'short') : ''}}</td>
                    <td>{{userContentCollection.pctUrl}}</td>
                    <td>{{userContentCollection.valid}}</td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'UserContentCollectionView', params: {userContentCollectionId: userContentCollection.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'UserContentCollectionEdit', params: {userContentCollectionId: userContentCollection.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(userContentCollection)"
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
            <span slot="modal-title"><span id="vip1App.userContentCollection.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-userContentCollection-heading" v-text="$t('vip1App.userContentCollection.delete.question', {'id': removeId})">Are you sure you want to delete this User Content Collection?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-userContentCollection" v-text="$t('entity.action.delete')" v-on:click="removeUserContentCollection()">Delete</button>
            </div>
        </b-modal>
        <div v-show="userContentCollections && userContentCollections.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./user-content-collection.component.ts">
</script>
