<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="infoItemVisitData">
                <h2 class="jh-entity-heading"><span v-text="$t('vip1App.infoItemVisitData.detail.title')">InfoItemVisitData</span> {{infoItemVisitData.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('vip1App.infoItemVisitData.userId')">User Id</span>
                    </dt>
                    <dd>
                        <span>{{infoItemVisitData.userId}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.infoItemVisitData.deviceNo')">Device No</span>
                    </dt>
                    <dd>
                        <span>{{infoItemVisitData.deviceNo}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.infoItemVisitData.date')">Date</span>
                    </dt>
                    <dd>
                        <span>{{infoItemVisitData.date}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.infoItemVisitData.source')">Source</span>
                    </dt>
                    <dd>
                        <span v-text="$t('vip1App.VisitSource.' + infoItemVisitData.source)">{{infoItemVisitData.source}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.infoItemVisitData.action')">Action</span>
                    </dt>
                    <dd>
                        <span>{{infoItemVisitData.action}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.infoItemVisitData.goods')">Goods</span>
                    </dt>
                    <dd>
                        <span>{{infoItemVisitData.goods}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.infoItemVisitData.termimal')">Termimal</span>
                    </dt>
                    <dd>
                        <span>{{infoItemVisitData.termimal}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.infoItemVisitData.streamItem')">Stream Item</span>
                    </dt>
                    <dd>
                        <div v-if="infoItemVisitData.streamItemId">
                            <router-link :to="{name: 'InfoStreamItemView', params: {infoStreamItemId: infoItemVisitData.streamItemId}}">{{infoItemVisitData.streamItemId}}</router-link>
                        </div>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="infoItemVisitData.id" :to="{name: 'InfoItemVisitDataEdit', params: {infoItemVisitDataId: infoItemVisitData.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./info-item-visit-data-details.component.ts">
</script>
