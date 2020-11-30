<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('vip1App.replyVisitDataStat.home.title')" id="reply-visit-data-stat-heading">Reply Visit Data Stats</span>
            <router-link :to="{name: 'ReplyVisitDataStatCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-reply-visit-data-stat">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('vip1App.replyVisitDataStat.home.createLabel')">
                    Create a new Reply Visit Data Stat
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
        <div class="alert alert-warning" v-if="!isFetching && replyVisitDataStats && replyVisitDataStats.length === 0">
            <span v-text="$t('vip1App.replyVisitDataStat.home.notFound')">No replyVisitDataStats found</span>
        </div>
        <div class="table-responsive" v-if="replyVisitDataStats && replyVisitDataStats.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('clickCount')"><span v-text="$t('vip1App.replyVisitDataStat.clickCount')">Click Count</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'clickCount'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('startDate')"><span v-text="$t('vip1App.replyVisitDataStat.startDate')">Start Date</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'startDate'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('endDate')"><span v-text="$t('vip1App.replyVisitDataStat.endDate')">End Date</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'endDate'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('source')"><span v-text="$t('vip1App.replyVisitDataStat.source')">Source</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'source'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('termimal')"><span v-text="$t('vip1App.replyVisitDataStat.termimal')">Termimal</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'termimal'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('replyCount')"><span v-text="$t('vip1App.replyVisitDataStat.replyCount')">Reply Count</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'replyCount'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('starCount')"><span v-text="$t('vip1App.replyVisitDataStat.starCount')">Star Count</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'starCount'"></jhi-sort-indicator></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="replyVisitDataStat in replyVisitDataStats"
                    :key="replyVisitDataStat.id">
                    <td>
                        <router-link :to="{name: 'ReplyVisitDataStatView', params: {replyVisitDataStatId: replyVisitDataStat.id}}">{{replyVisitDataStat.id}}</router-link>
                    </td>
                    <td>{{replyVisitDataStat.clickCount}}</td>
                    <td>{{replyVisitDataStat.startDate}}</td>
                    <td>{{replyVisitDataStat.endDate}}</td>
                    <td v-text="$t('vip1App.VisitSource.' + replyVisitDataStat.source)">{{replyVisitDataStat.source}}</td>
                    <td>{{replyVisitDataStat.termimal}}</td>
                    <td>{{replyVisitDataStat.replyCount}}</td>
                    <td>{{replyVisitDataStat.starCount}}</td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'ReplyVisitDataStatView', params: {replyVisitDataStatId: replyVisitDataStat.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'ReplyVisitDataStatEdit', params: {replyVisitDataStatId: replyVisitDataStat.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(replyVisitDataStat)"
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
            <span slot="modal-title"><span id="vip1App.replyVisitDataStat.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-replyVisitDataStat-heading" v-text="$t('vip1App.replyVisitDataStat.delete.question', {'id': removeId})">Are you sure you want to delete this Reply Visit Data Stat?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-replyVisitDataStat" v-text="$t('entity.action.delete')" v-on:click="removeReplyVisitDataStat()">Delete</button>
            </div>
        </b-modal>
        <div v-show="replyVisitDataStats && replyVisitDataStats.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./reply-visit-data-stat.component.ts">
</script>
