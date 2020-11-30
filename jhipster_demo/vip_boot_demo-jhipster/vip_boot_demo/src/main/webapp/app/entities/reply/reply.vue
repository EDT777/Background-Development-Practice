<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('vip1App.reply.home.title')" id="reply-heading">Replies</span>
            <router-link :to="{name: 'ReplyCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-reply">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('vip1App.reply.home.createLabel')">
                    Create a new Reply
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
        <div class="alert alert-warning" v-if="!isFetching && replies && replies.length === 0">
            <span v-text="$t('vip1App.reply.home.notFound')">No replies found</span>
        </div>
        <div class="table-responsive" v-if="replies && replies.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('title')"><span v-text="$t('vip1App.reply.title')">Title</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'title'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('content')"><span v-text="$t('vip1App.reply.content')">Content</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'content'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('auditStatus')"><span v-text="$t('vip1App.reply.auditStatus')">Audit Status</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'auditStatus'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('createData')"><span v-text="$t('vip1App.reply.createData')">Create Data</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createData'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('auditDate')"><span v-text="$t('vip1App.reply.auditDate')">Audit Date</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'auditDate'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('createUser')"><span v-text="$t('vip1App.reply.createUser')">Create User</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createUser'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('auditUser')"><span v-text="$t('vip1App.reply.auditUser')">Audit User</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'auditUser'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('replyUserId')"><span v-text="$t('vip1App.reply.replyUserId')">Reply User Id</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'replyUserId'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('replyUserNickName')"><span v-text="$t('vip1App.reply.replyUserNickName')">Reply User Nick Name</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'replyUserNickName'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('delFlag')"><span v-text="$t('vip1App.reply.delFlag')">Del Flag</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'delFlag'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('replyToId')"><span v-text="$t('vip1App.reply.replyTo')">Reply To</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'replyToId'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('itemId')"><span v-text="$t('vip1App.reply.item')">Item</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'itemId'"></jhi-sort-indicator></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="reply in replies"
                    :key="reply.id">
                    <td>
                        <router-link :to="{name: 'ReplyView', params: {replyId: reply.id}}">{{reply.id}}</router-link>
                    </td>
                    <td>{{reply.title}}</td>
                    <td>{{reply.content}}</td>
                    <td>{{reply.auditStatus}}</td>
                    <td>{{reply.createData ? $d(Date.parse(reply.createData), 'short') : ''}}</td>
                    <td>{{reply.auditDate ? $d(Date.parse(reply.auditDate), 'short') : ''}}</td>
                    <td>{{reply.createUser}}</td>
                    <td>{{reply.auditUser}}</td>
                    <td>{{reply.replyUserId}}</td>
                    <td>{{reply.replyUserNickName}}</td>
                    <td>{{reply.delFlag}}</td>
                    <td>
                        <div v-if="reply.replyToId">
                            <router-link :to="{name: 'ReplyView', params: {replyId: reply.replyToId}}">{{reply.replyToId}}</router-link>
                        </div>
                    </td>
                    <td>
                        <div v-if="reply.itemId">
                            <router-link :to="{name: 'InfoStreamItemView', params: {infoStreamItemId: reply.itemId}}">{{reply.itemId}}</router-link>
                        </div>
                    </td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'ReplyView', params: {replyId: reply.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'ReplyEdit', params: {replyId: reply.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(reply)"
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
            <span slot="modal-title"><span id="vip1App.reply.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-reply-heading" v-text="$t('vip1App.reply.delete.question', {'id': removeId})">Are you sure you want to delete this Reply?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-reply" v-text="$t('entity.action.delete')" v-on:click="removeReply()">Delete</button>
            </div>
        </b-modal>
        <div v-show="replies && replies.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./reply.component.ts">
</script>
