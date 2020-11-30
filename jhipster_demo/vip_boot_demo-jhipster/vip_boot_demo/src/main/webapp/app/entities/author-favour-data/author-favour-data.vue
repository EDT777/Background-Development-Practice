<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('vip1App.authorFavourData.home.title')" id="author-favour-data-heading">Author Favour Data</span>
            <router-link :to="{name: 'AuthorFavourDataCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-author-favour-data">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('vip1App.authorFavourData.home.createLabel')">
                    Create a new Author Favour Data
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
        <div class="alert alert-warning" v-if="!isFetching && authorFavourData && authorFavourData.length === 0">
            <span v-text="$t('vip1App.authorFavourData.home.notFound')">No authorFavourData found</span>
        </div>
        <div class="table-responsive" v-if="authorFavourData && authorFavourData.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('userId')"><span v-text="$t('vip1App.authorFavourData.userId')">User Id</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'userId'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('createDate')"><span v-text="$t('vip1App.authorFavourData.createDate')">Create Date</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createDate'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('authorId')"><span v-text="$t('vip1App.authorFavourData.author')">Author</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'authorId'"></jhi-sort-indicator></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="authorFavourData in authorFavourData"
                    :key="authorFavourData.id">
                    <td>
                        <router-link :to="{name: 'AuthorFavourDataView', params: {authorFavourDataId: authorFavourData.id}}">{{authorFavourData.id}}</router-link>
                    </td>
                    <td>{{authorFavourData.userId}}</td>
                    <td>{{authorFavourData.createDate ? $d(Date.parse(authorFavourData.createDate), 'short') : ''}}</td>
                    <td>
                        <div v-if="authorFavourData.authorId">
                            <router-link :to="{name: 'AuthorView', params: {authorId: authorFavourData.authorId}}">{{authorFavourData.authorId}}</router-link>
                        </div>
                    </td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'AuthorFavourDataView', params: {authorFavourDataId: authorFavourData.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'AuthorFavourDataEdit', params: {authorFavourDataId: authorFavourData.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(authorFavourData)"
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
            <span slot="modal-title"><span id="vip1App.authorFavourData.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-authorFavourData-heading" v-text="$t('vip1App.authorFavourData.delete.question', {'id': removeId})">Are you sure you want to delete this Author Favour Data?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-authorFavourData" v-text="$t('entity.action.delete')" v-on:click="removeAuthorFavourData()">Delete</button>
            </div>
        </b-modal>
        <div v-show="authorFavourData && authorFavourData.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./author-favour-data.component.ts">
</script>
