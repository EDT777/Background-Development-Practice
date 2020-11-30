<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="reply">
                <h2 class="jh-entity-heading"><span v-text="$t('vip1App.reply.detail.title')">Reply</span> {{reply.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('vip1App.reply.title')">Title</span>
                    </dt>
                    <dd>
                        <span>{{reply.title}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.reply.content')">Content</span>
                    </dt>
                    <dd>
                        <span>{{reply.content}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.reply.auditStatus')">Audit Status</span>
                    </dt>
                    <dd>
                        <span>{{reply.auditStatus}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.reply.createData')">Create Data</span>
                    </dt>
                    <dd>
                        <span v-if="reply.createData">{{$d(Date.parse(reply.createData), 'long') }}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.reply.auditDate')">Audit Date</span>
                    </dt>
                    <dd>
                        <span v-if="reply.auditDate">{{$d(Date.parse(reply.auditDate), 'long') }}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.reply.createUser')">Create User</span>
                    </dt>
                    <dd>
                        <span>{{reply.createUser}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.reply.auditUser')">Audit User</span>
                    </dt>
                    <dd>
                        <span>{{reply.auditUser}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.reply.replyUserId')">Reply User Id</span>
                    </dt>
                    <dd>
                        <span>{{reply.replyUserId}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.reply.replyUserNickName')">Reply User Nick Name</span>
                    </dt>
                    <dd>
                        <span>{{reply.replyUserNickName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.reply.delFlag')">Del Flag</span>
                    </dt>
                    <dd>
                        <span>{{reply.delFlag}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.reply.replyTo')">Reply To</span>
                    </dt>
                    <dd>
                        <div v-if="reply.replyToId">
                            <router-link :to="{name: 'ReplyView', params: {replyId: reply.replyToId}}">{{reply.replyToId}}</router-link>
                        </div>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.reply.item')">Item</span>
                    </dt>
                    <dd>
                        <div v-if="reply.itemId">
                            <router-link :to="{name: 'InfoStreamItemView', params: {infoStreamItemId: reply.itemId}}">{{reply.itemId}}</router-link>
                        </div>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="reply.id" :to="{name: 'ReplyEdit', params: {replyId: reply.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./reply-details.component.ts">
</script>
