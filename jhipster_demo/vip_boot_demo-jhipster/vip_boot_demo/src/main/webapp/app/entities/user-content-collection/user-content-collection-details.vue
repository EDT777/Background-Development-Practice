<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="userContentCollection">
                <h2 class="jh-entity-heading"><span v-text="$t('vip1App.userContentCollection.detail.title')">UserContentCollection</span> {{userContentCollection.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('vip1App.userContentCollection.userId')">User Id</span>
                    </dt>
                    <dd>
                        <span>{{userContentCollection.userId}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.userContentCollection.platform')">Platform</span>
                    </dt>
                    <dd>
                        <span>{{userContentCollection.platform}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.userContentCollection.link')">Link</span>
                    </dt>
                    <dd>
                        <span>{{userContentCollection.link}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.userContentCollection.createDate')">Create Date</span>
                    </dt>
                    <dd>
                        <span v-if="userContentCollection.createDate">{{$d(Date.parse(userContentCollection.createDate), 'long') }}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.userContentCollection.pctUrl')">Pct Url</span>
                    </dt>
                    <dd>
                        <span>{{userContentCollection.pctUrl}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.userContentCollection.valid')">Valid</span>
                    </dt>
                    <dd>
                        <span>{{userContentCollection.valid}}</span>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="userContentCollection.id" :to="{name: 'UserContentCollectionEdit', params: {userContentCollectionId: userContentCollection.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./user-content-collection-details.component.ts">
</script>
