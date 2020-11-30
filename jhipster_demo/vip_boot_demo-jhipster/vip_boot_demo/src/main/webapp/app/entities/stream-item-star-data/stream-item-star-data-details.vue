<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="streamItemStarData">
                <h2 class="jh-entity-heading"><span v-text="$t('vip1App.streamItemStarData.detail.title')">StreamItemStarData</span> {{streamItemStarData.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('vip1App.streamItemStarData.userId')">User Id</span>
                    </dt>
                    <dd>
                        <span>{{streamItemStarData.userId}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.streamItemStarData.createDate')">Create Date</span>
                    </dt>
                    <dd>
                        <span v-if="streamItemStarData.createDate">{{$d(Date.parse(streamItemStarData.createDate), 'long') }}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.streamItemStarData.type')">Type</span>
                    </dt>
                    <dd>
                        <span>{{streamItemStarData.type}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.streamItemStarData.itemId')">Item Id</span>
                    </dt>
                    <dd>
                        <span>{{streamItemStarData.itemId}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.streamItemStarData.replayId')">Replay Id</span>
                    </dt>
                    <dd>
                        <span>{{streamItemStarData.replayId}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.streamItemStarData.valid')">Valid</span>
                    </dt>
                    <dd>
                        <span>{{streamItemStarData.valid}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.streamItemStarData.starType')">Star Type</span>
                    </dt>
                    <dd>
                        <span>{{streamItemStarData.starType}}</span>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="streamItemStarData.id" :to="{name: 'StreamItemStarDataEdit', params: {streamItemStarDataId: streamItemStarData.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./stream-item-star-data-details.component.ts">
</script>
