<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="infoItemVisitDataStat">
                <h2 class="jh-entity-heading"><span v-text="$t('vip1App.infoItemVisitDataStat.detail.title')">InfoItemVisitDataStat</span> {{infoItemVisitDataStat.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('vip1App.infoItemVisitDataStat.clickCount')">Click Count</span>
                    </dt>
                    <dd>
                        <span>{{infoItemVisitDataStat.clickCount}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.infoItemVisitDataStat.startDate')">Start Date</span>
                    </dt>
                    <dd>
                        <span>{{infoItemVisitDataStat.startDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.infoItemVisitDataStat.endDate')">End Date</span>
                    </dt>
                    <dd>
                        <span>{{infoItemVisitDataStat.endDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.infoItemVisitDataStat.source')">Source</span>
                    </dt>
                    <dd>
                        <span v-text="$t('vip1App.VisitSource.' + infoItemVisitDataStat.source)">{{infoItemVisitDataStat.source}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.infoItemVisitDataStat.termimal')">Termimal</span>
                    </dt>
                    <dd>
                        <span>{{infoItemVisitDataStat.termimal}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.infoItemVisitDataStat.replyCount')">Reply Count</span>
                    </dt>
                    <dd>
                        <span>{{infoItemVisitDataStat.replyCount}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.infoItemVisitDataStat.starCount')">Star Count</span>
                    </dt>
                    <dd>
                        <span>{{infoItemVisitDataStat.starCount}}</span>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="infoItemVisitDataStat.id" :to="{name: 'InfoItemVisitDataStatEdit', params: {infoItemVisitDataStatId: infoItemVisitDataStat.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./info-item-visit-data-stat-details.component.ts">
</script>
