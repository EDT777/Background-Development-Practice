<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="infoStreamItem">
                <h2 class="jh-entity-heading"><span v-text="$t('vip1App.infoStreamItem.detail.title')">InfoStreamItem</span> {{infoStreamItem.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('vip1App.infoStreamItem.title')">Title</span>
                    </dt>
                    <dd>
                        <span>{{infoStreamItem.title}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.infoStreamItem.type')">Type</span>
                    </dt>
                    <dd>
                        <span>{{infoStreamItem.type}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.infoStreamItem.digist')">Digist</span>
                    </dt>
                    <dd>
                        <span>{{infoStreamItem.digist}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.infoStreamItem.content')">Content</span>
                    </dt>
                    <dd>
                        <span>{{infoStreamItem.content}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.infoStreamItem.createUser')">Create User</span>
                    </dt>
                    <dd>
                        <span>{{infoStreamItem.createUser}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.infoStreamItem.lastUpdateDate')">Last Update Date</span>
                    </dt>
                    <dd>
                        <span v-if="infoStreamItem.lastUpdateDate">{{$d(Date.parse(infoStreamItem.lastUpdateDate), 'long') }}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.infoStreamItem.updateUser')">Update User</span>
                    </dt>
                    <dd>
                        <span>{{infoStreamItem.updateUser}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.infoStreamItem.createDate')">Create Date</span>
                    </dt>
                    <dd>
                        <span v-if="infoStreamItem.createDate">{{$d(Date.parse(infoStreamItem.createDate), 'long') }}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.infoStreamItem.tags')">Tags</span>
                    </dt>
                    <dd>
                        <span>{{infoStreamItem.tags}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.infoStreamItem.contentType')">Content Type</span>
                    </dt>
                    <dd>
                        <span v-text="$t('vip1App.ItemResourceType.' + infoStreamItem.contentType)">{{infoStreamItem.contentType}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.infoStreamItem.author')">Author</span>
                    </dt>
                    <dd>
                        <div v-if="infoStreamItem.authorId">
                            <router-link :to="{name: 'AuthorView', params: {authorId: infoStreamItem.authorId}}">{{infoStreamItem.authorId}}</router-link>
                        </div>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="infoStreamItem.id" :to="{name: 'InfoStreamItemEdit', params: {infoStreamItemId: infoStreamItem.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./info-stream-item-details.component.ts">
</script>
